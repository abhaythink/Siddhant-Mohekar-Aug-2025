package com.think.restapi.rapi.Exception;

import java.time.LocalDate;

public class ErrorDetails {
    
    private LocalDate date;
    private String messege;
    private String details;
    public ErrorDetails() {
    }
    public ErrorDetails(LocalDate date, String messege, String details) {
        this.date = date;
        this.messege = messege;
        this.details = details;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getMessege() {
        return messege;
    }
    public void setMessege(String messege) {
        this.messege = messege;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    @Override
    public String toString() {
        return "ErrorDetails [date=" + date + ", messege=" + messege + ", details=" + details + "]";
    }

    
}
