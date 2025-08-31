package com.think.jpaprac.sbjpahibernate.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {
    
    @Id
    private int pid;
    private String pname;
    private String doctorname;

    
    public Patient() {
    }
    
    public int getPid() {
        return pid;
    }
    public Patient(int pid, String pname, String doctorname) {
        this.pid = pid;
        this.pname = pname;
        this.doctorname = doctorname;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getDoctorname() {
        return doctorname;
    }
    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }
    @Override
    public String toString() {
        return "Patient [pid=" + pid + ", pname=" + pname + ", doctorname=" + doctorname + "]";
    }

    
}
