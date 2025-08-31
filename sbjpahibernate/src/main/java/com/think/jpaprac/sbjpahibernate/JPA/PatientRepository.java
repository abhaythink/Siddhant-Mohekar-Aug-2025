package com.think.jpaprac.sbjpahibernate.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.think.jpaprac.sbjpahibernate.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{

    public List<Patient> findByDoctorname(String doctorname);
    public List<Patient> findByPname(String pname);
    
}
