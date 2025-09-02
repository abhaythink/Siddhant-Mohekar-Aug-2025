package com.think.doctorservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.think.doctorservice.Entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,String>{
    
}
