package com.example.hbs;

import com.example.hbs.domain.Address;
import com.example.hbs.service.AddressService;
import com.example.hbs.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelbookingApplication implements CommandLineRunner {

	//@Autowired
	private HotelService hotelService;

	//@Autowired
	private AddressService addressService;

	@Autowired
	public HotelbookingApplication(HotelService hotelService, AddressService addressService) {
		this.hotelService = hotelService;
		this.addressService = addressService;
	}




	public static void main(String[] args) {
		SpringApplication.run(HotelbookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = addressService.createRAddress( 1,"1000 N st", "ddff","dfsd","dff","fd");
		hotelService.createHotel("Hotel x", "hotel xxx", "//htsddds",address);
	}

}
