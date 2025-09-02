package com.think.appointmentmangement.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Patient {

    @Id
    private String id;
    @NotNull(message = "doctor id is Required")
    private String doctorid;
    @NotNull(message = "Name is Required")
    @Size(min = 2,max = 25)
    private String name;
    @NotNull(message = "Age is Required")
    private int age;
    @NotNull(message = "Email is Required")
    @Email
    private String email;
    @NotNull
    private String slotTime;
    private String status = "BOOKED";
    @NotNull(message = "Appointment Date is Required")
    private LocalDate appointmentDate;

    @Transient
    private Doctor doctor;
    
}
