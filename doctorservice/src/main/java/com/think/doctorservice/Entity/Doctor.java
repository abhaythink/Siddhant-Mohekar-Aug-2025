package com.think.doctorservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Doctor {
    
    @Id
    private String id;
    @NotNull(message = "Name cannot be null")
    @Size(min=2,max=25)
    private String name;
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
    @NotNull(message = "Specialist cannot be null")
    private String specialist;
}
