package com.think.restapi.rapi.ReportsDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.think.restapi.rapi.Entity.Reports;

@Component
public class ReportData {

    private static List<Reports> reports = new ArrayList<>();

    private static int rcount = 0;

    static{
        reports.add(rcount++,new Reports(101,"Ravish","MRI",LocalDate.now()));
        reports.add(rcount++,new Reports(102,"Mahesh","DentalReport",LocalDate.now()));
        reports.add(rcount++,new Reports(103,"Paras","BloodReport",LocalDate.now()));
    }

    public List<Reports> findAll(){
        return reports;
    }

    public Reports getReportById(int id) {
         return reports.stream().filter(rep-> rep.getId() == id).findFirst().get();
    }

    public Reports addRep(Reports rep) {
        rep.setId(rcount++);
        reports.add(rep);
        return rep;
    }

    public void deleteById(int id) {
        reports.remove(reports.stream().filter(rep-> rep.getId() == id).findFirst().get());
    }
    
}
