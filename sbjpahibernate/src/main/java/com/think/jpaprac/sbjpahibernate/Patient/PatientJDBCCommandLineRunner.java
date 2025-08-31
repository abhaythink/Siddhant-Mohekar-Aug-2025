package com.think.jpaprac.sbjpahibernate.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.think.jpaprac.sbjpahibernate.Entity.Patient;
import com.think.jpaprac.sbjpahibernate.JPA.PatientRepository;

@Component
public class PatientJDBCCommandLineRunner implements CommandLineRunner{

    // @Autowired
    // private PatientJDBCRepository cmdrunner;

    // @Autowired
    // private PatientJpaRepo cmdrunner;

    @Autowired
    private PatientRepository pr;

    @Override
    public void run(String... args) throws Exception {
        pr.save(new Patient(101,"Ravish","DR Mahesh")); 
        pr.save(new Patient(102,"Aryan","DR Suresh"));  
        pr.deleteById(101); 
        System.out.println(pr.findById(102));

        System.out.println(pr.findAll());
        System.out.println(pr.findByDoctorname("DR Suresh"));
        System.out.println(pr.findByPname("Aryan"));
    }
    
}
