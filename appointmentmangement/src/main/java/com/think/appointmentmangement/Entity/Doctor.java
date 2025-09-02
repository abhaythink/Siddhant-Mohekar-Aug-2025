package com.think.appointmentmangement.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Doctor {
    
    private String id;
    private String name;
    private String email;
    private String specialist;
}
