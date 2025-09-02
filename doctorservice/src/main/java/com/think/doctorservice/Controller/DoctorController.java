package com.think.doctorservice.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.think.doctorservice.Entity.Doctor;
import com.think.doctorservice.Exception.DoctorNotFoundException;
import com.think.doctorservice.Service.DoctorService;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> getSingleDoctor(@PathVariable String id) throws DoctorNotFoundException{
        Doctor d = doctorService.getDoctorById(id);
        return ResponseEntity.ok(d);
    }

    @PostMapping("/doctor/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        doctor.setId(UUID.randomUUID().toString());
        doctorService.addDoctor(doctor);
        return ResponseEntity.ok(doctor);
    }

    @DeleteMapping("/doctor/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
        String msg = doctorService.deleteDoctor(id);
        return ResponseEntity.ok(msg);
    }

}