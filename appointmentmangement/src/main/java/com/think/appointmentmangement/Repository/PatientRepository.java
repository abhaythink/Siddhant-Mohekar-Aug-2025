package com.think.appointmentmangement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.think.appointmentmangement.Entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,String>{
    
}
