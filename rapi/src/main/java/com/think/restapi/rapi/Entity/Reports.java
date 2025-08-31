package com.think.restapi.rapi.Entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
public class Reports {
    
    @NonNull
    private int id;
    @NotNull
    @Size(min = 2,max = 30)
    private String name;
    @NotNull
    private String reportType;
    @NotNull
    private LocalDate date;

    
    public Reports() {
    }
    public Reports(int id, String name, String reportType, LocalDate date) {
        this.id = id;
        this.name = name;
        this.reportType = reportType;
        this.date = date;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getReportType() {
        return reportType;
    }
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Reports [id=" + id + ", name=" + name + ", reportType=" + reportType + ", date=" + date + "]";
    }

    

}
