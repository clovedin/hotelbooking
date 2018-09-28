package com.clovedin.booking.stock;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelStockApp {
	
	public static void main(String[] args) {
		SpringApplication.run(HotelStockApp.class, args);
	}
	
	@PostConstruct
	public void deploy() {
	}

}
