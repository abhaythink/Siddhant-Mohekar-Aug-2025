package com.think.appointmentmangement.Service;

import java.util.List;

import com.think.appointmentmangement.Entity.Patient;
import com.think.appointmentmangement.Exception.DateException;
import com.think.appointmentmangement.Exception.PatientNotFoundException;

public interface PatientService {

    public Patient getPatient(String id) throws PatientNotFoundException;
    public List<Patient> getAllPatients();
    public void deletePatient(String id) throws PatientNotFoundException;
    public String addPatient(Patient patient) throws DateException;
    public String updateDetails(String id, Patient patient) throws PatientNotFoundException;
}
