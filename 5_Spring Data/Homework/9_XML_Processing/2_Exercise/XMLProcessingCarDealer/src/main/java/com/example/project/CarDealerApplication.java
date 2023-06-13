package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDealerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDealerApplication.class, args);
	}

	//Just launch and everything will pop-up in resources/export folder

	//A note on the task 6 - I made the discount percent in units (eg. "10", "30", etc.),
	//not in math percent (eg. "0.1", "0.3", etc.) but the calculation works nevertheless

}
