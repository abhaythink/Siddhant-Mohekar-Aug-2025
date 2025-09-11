package com.think.appointmentmangement.DAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.think.appointmentmangement.Entity.Doctor;
import com.think.appointmentmangement.Entity.Patient;
import com.think.appointmentmangement.Exception.DateException;
import com.think.appointmentmangement.Exception.EmailAlreadyExsistException;
import com.think.appointmentmangement.Exception.PatientNotFoundException;
import com.think.appointmentmangement.Exception.TimeSlotIsAlreadyBookException;
import com.think.appointmentmangement.Repository.PatientRepository;
import com.think.appointmentmangement.Service.NotificationService;
import com.think.appointmentmangement.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService ns;

    @Override
    public Patient getPatient(String id) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("Patient having "+id+" Not found"));
        Doctor doctor = restTemplate.getForObject("http://localhost:9195/doctor/"+patient.getDoctorid(), Doctor.class);
        patient.setDoctor(doctor);
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> lp =  patientRepository.findAll();
        
        return lp.stream().map(pd -> {
            Doctor doctor = restTemplate.getForObject("http://localhost:9195/doctor/"+pd.getDoctorid(), Doctor.class);
            pd.setDoctor(doctor);
            return pd;
        }).collect(Collectors.toList());
        
    }

    @Override
    public void deletePatient(String id) throws PatientNotFoundException {
        if(id == null){
            throw new PatientNotFoundException("Patient having "+id+" Not found");
        }
       patientRepository.deleteById(id);
    }

    @Override
    public String addPatient(Patient patient) throws DateException, TimeSlotIsAlreadyBookException, EmailAlreadyExsistException {
        if(patient.getAppointmentDate().isBefore(LocalDate.now())){
            throw new DateException("Date should be in future");
        }
        // LocalTime s = LocalTime.of(9, 0);
        // LocalTime e = LocalTime.of(14, 0);
        // List<String> ts =  this.createTimeSlots(s, e, 30);
        // if(ts.contains(patient.getSlotTime())){
        //     throw new TimeSlotIsAlreadyBookException("Time slot is already booked");
        // }

        boolean slotIsBooked = patientRepository.existsByDoctoridAndAppointmentDateAndSlotTime(patient.getDoctorid(), patient.getAppointmentDate(), patient.getSlotTime());
        if(slotIsBooked){
            throw new TimeSlotIsAlreadyBookException("Time slot is already booked");
        }
        boolean isEmailExist = patientRepository.existsByEmail(patient.getEmail());
        if(isEmailExist){
            throw new EmailAlreadyExsistException("Email : "+patient.getEmail() + " is already have appointment");
        }
        ns.sendMail(patient.getEmail(), "Booked Time :"+patient.getSlotTime() + " is on Date: "+ patient.getAppointmentDate());
        Doctor doctor = restTemplate.getForObject("http://localhost:9195/doctor/"+patient.getDoctorid(), Doctor.class);
         patient.setDoctor(doctor);
        patientRepository.save(patient);
        return "added Successful";
    }

    @Override
    public String updateDetails(String id, Patient patient) throws PatientNotFoundException {
       
        Patient p = patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("Patient having "+id+" Not found"));
        if(patient.getName()!=null) p.setName(patient.getName());
        if(patient.getAge() >= 0 && patient.getAge() <= 120) p.setAge(patient.getAge());
        if(patient.getEmail()!=null) p.setEmail(patient.getName());
        patientRepository.save(p);

        return "data Updated";
    }

    @Override
    public List<String> createTimeSlots(LocalTime s, LocalTime e, int sm) {
       List<String> ts = new ArrayList<>();
       LocalTime ct = s;

       while(!ct.plusMinutes(sm).isAfter(e)){
        String slot = ct + "-" + ct.plusMinutes(sm);
        ts.add(slot);
        ct = ct.plusMinutes(sm);
       }
       System.out.println(ts);
       return ts;
    }

    @Override
    public List<String> getAvailableTimeSlots(String doctorid, LocalTime appointmentDate) {
         List<String> allSlots = this.createTimeSlots(LocalTime.of(9, 0), LocalTime.of(17, 0), 30);

         List<String> bookedSlots = patientRepository.findByDoctoridAndAppointmentDate(doctorid, appointmentDate)
                                    .stream().map(Patient::getSlotTime).toList();

        allSlots.removeAll(bookedSlots);
        return allSlots;
    }
    
}
