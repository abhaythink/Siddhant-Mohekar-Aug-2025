package com.think.jpaprac.sbjpahibernate.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.think.jpaprac.sbjpahibernate.Entity.Patient;

@Repository
public class PatientJDBCRepository {
    
    @Autowired
    private JdbcTemplate template;
    
    public static String INSERT_QUERY = 
              """
                insert into Patient(pid,pname,doctorname)
                values(?,?,?);         
              """;

     public static String DELETE_QUERY = 
              """
                delete from Patient where pid = ?;        
              """;
    public static String SELECT_QUERY = 
              """
                select * from Patient where pid = ?;        
              """;

      public void insert(Patient patient){
            template.update(INSERT_QUERY,patient.getPid(),patient.getPname(),patient.getDoctorname());
      }

      public void delete(int id){
        template.update(DELETE_QUERY, id);
      }

      public Patient select(int id){
        return template.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Patient.class),id);
      }
}
