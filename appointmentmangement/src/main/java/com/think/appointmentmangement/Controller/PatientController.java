package com.think.appointmentmangement.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.think.appointmentmangement.Entity.Patient;
import com.think.appointmentmangement.Exception.DateException;
import com.think.appointmentmangement.Exception.PatientNotFoundException;
import com.think.appointmentmangement.Service.PatientService;

import jakarta.validation.Valid;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable String id) throws PatientNotFoundException{
        return patientService.getPatient(id);
    }

    @PostMapping("/patient/add")
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) throws DateException{
        patient.setId(UUID.randomUUID().toString());
        patientService.addPatient(patient);
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/patient/getAll")
    public List<Patient> getAllPatient(){
        return patientService.getAllPatients();
    }

    @DeleteMapping("/patient/delete/{id}")
    public void deletePatient(@PathVariable String id) throws PatientNotFoundException{
        patientService.deletePatient(id);
    }

    @PutMapping("/patient/update/{id}")
    public ResponseEntity<String> updateData(@PathVariable String id,@RequestBody Patient patient) throws PatientNotFoundException{
        String msg = patientService.updateDetails(id, patient);
        return ResponseEntity.ok(msg);
    }
    
}
