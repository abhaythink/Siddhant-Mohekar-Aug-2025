package com.think.appointmentmangement.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.think.appointmentmangement.Service.NotificationService;

@Service
public class NotifiactionServiceImpl implements NotificationService{

    @Autowired
    private JavaMailSender jms;

    @Override
    public void sendMail(String to, String msg) {
       SimpleMailMessage sm = new SimpleMailMessage();
       sm.setTo(to);
       sm.setSubject("Appointment BOOKED");
       sm.setText(msg);
       jms.send(sm);
    }
    
}
