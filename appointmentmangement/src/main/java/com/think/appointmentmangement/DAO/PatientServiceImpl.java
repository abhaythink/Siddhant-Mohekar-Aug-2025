package com.think.appointmentmangement.DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.think.appointmentmangement.Entity.Doctor;
import com.think.appointmentmangement.Entity.Patient;
import com.think.appointmentmangement.Exception.DateException;
import com.think.appointmentmangement.Exception.PatientNotFoundException;
import com.think.appointmentmangement.Repository.PatientRepository;
import com.think.appointmentmangement.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RestTemplate restTemplate;

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
    public String addPatient(Patient patient) throws DateException {
        if(patient.getAppointmentDate().isBefore(LocalDate.now())){
            throw new DateException("Date should be in future");
        }
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
    
}
