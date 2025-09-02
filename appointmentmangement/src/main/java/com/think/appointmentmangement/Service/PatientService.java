package com.think.appointmentmangement.Service;

import java.time.LocalTime;
import java.util.List;

import com.think.appointmentmangement.Entity.Patient;
import com.think.appointmentmangement.Exception.DateException;
import com.think.appointmentmangement.Exception.EmailAlreadyExsistException;
import com.think.appointmentmangement.Exception.PatientNotFoundException;
import com.think.appointmentmangement.Exception.TimeSlotIsAlreadyBookException;

public interface PatientService {

    public Patient getPatient(String id) throws PatientNotFoundException;
    public List<Patient> getAllPatients();
    public void deletePatient(String id) throws PatientNotFoundException;
    public String addPatient(Patient patient) throws DateException ,TimeSlotIsAlreadyBookException,EmailAlreadyExsistException;
    public String updateDetails(String id, Patient patient) throws PatientNotFoundException;
    public List<String> createTimeSlots(LocalTime s,LocalTime e,int sm);
    public List<String> getAvailableTimeSlots(String doctorid, LocalTime appointmentDate);
}
