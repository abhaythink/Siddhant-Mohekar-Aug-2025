package com.think.appointmentmangement.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.think.appointmentmangement.Entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,String>{
    
    boolean existsByDoctoridAndAppointmentDateAndSlotTime(
            String doctorid, LocalDate appointmentDate, String slotTime);

    List<Patient> findByDoctoridAndAppointmentDate(
            String doctorid, LocalTime appointmentDate);

    boolean existsByEmail(String email);
}
