package com.think.appointmentmangement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AppointmentmangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentmangementApplication.class, args);
	}

	return new RestTemplate();
	}

}
