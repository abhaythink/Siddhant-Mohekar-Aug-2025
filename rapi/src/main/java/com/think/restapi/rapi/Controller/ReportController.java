package com.think.restapi.rapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.think.restapi.rapi.Entity.Reports;
import com.think.restapi.rapi.Exception.UserNotFoundException;
import com.think.restapi.rapi.ReportsDao.ReportData;

import jakarta.validation.Valid;

@RestController
public class ReportController {
    
    // @RequestMapping(method = RequestMethod.GET,path = "/get-reports")
    // public String getReports(){
    //     return "Here are the reports";
    // }

    @Autowired
    private ReportData rd;

    // public ReportController(ReportData rd){
    //     this.rd = rd;
    // }

     @GetMapping("/get-reports/{name}")
    public String getReports(@PathVariable String name){
        return "Here are the reports of " + name;
    }

    @GetMapping("/reports/all")
    public List<Reports> getAllData(){
        return rd.findAll();
    } 

    @GetMapping("/reports/{id}")
    public Reports getSingleReport(@PathVariable int id) throws UserNotFoundException{
        if(id == 0) {
        throw new UserNotFoundException("User not exists");
        }
        
        return rd.getReportById(id);
    }

    @PostMapping("reports/add")
    public ResponseEntity<Reports> addReport(@Valid @RequestBody Reports rep){
        Reports rp = rd.addRep(rep);
       return ResponseEntity.ok(rp);
    }

    @DeleteMapping("/reports/delete/{id}")
    public void delete(@PathVariable int id){
        rd.deleteById(id);
    }
}
