package com.clovedin.hotelbooking.stock;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.vertx.core.Vertx;

@SpringBootApplication
public class HotelStockApp {

	@Autowired
	private StockVerticle stockVerticle;
	
	public static void main(String[] args) {
		SpringApplication.run(HotelStockApp.class, args);
	}
	
	@PostConstruct
	public void deploy() {
		Vertx.vertx().deployVerticle(stockVerticle);
	}

}
