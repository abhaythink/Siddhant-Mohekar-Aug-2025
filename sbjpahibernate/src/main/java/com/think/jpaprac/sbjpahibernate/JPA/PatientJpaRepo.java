package com.think.jpaprac.sbjpahibernate.JPA;

import org.springframework.stereotype.Repository;

import com.think.jpaprac.sbjpahibernate.Entity.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PatientJpaRepo {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Patient p){
        em.merge(p);
    }

    public Patient findById(int id){
        return em.find(Patient.class, id);
    }

    public void deleteById(int id){
        Patient p = em.find(Patient.class, id);
        em.remove(p);
    }
}
