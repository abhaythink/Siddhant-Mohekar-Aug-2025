package com.think.doctorservice.Service;

import com.think.doctorservice.Entity.Doctor;
import com.think.doctorservice.Exception.DoctorNotFoundException;

public interface DoctorService {
    
    public void addDoctor(Doctor doctor);
    public Doctor getDoctorById(String id) throws DoctorNotFoundException;
    public String deleteDoctor(String id);

}
