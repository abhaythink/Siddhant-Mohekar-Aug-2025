package com.think.doctorservice.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.think.doctorservice.Entity.Doctor;
import com.think.doctorservice.Exception.DoctorNotFoundException;
import com.think.doctorservice.Repository.DoctorRepository;
import com.think.doctorservice.Service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);  
    }

    @Override
    public Doctor getDoctorById(String id) throws DoctorNotFoundException {
        return doctorRepository.findById(id).orElseThrow(()->new DoctorNotFoundException("Doctor of "+ id + " Not found"));
    }

    @Override
    public String deleteDoctor(String id) {
        doctorRepository.deleteById(id);
        return "Deleted Succesfully";
    }
    
}
