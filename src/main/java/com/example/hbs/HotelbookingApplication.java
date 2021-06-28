package com.example.hbs;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Address;
import com.example.hbs.domain.Role;
import com.example.hbs.service.AccountService;
import com.example.hbs.service.AddressService;
import com.example.hbs.service.HotelService;
import com.example.hbs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class HotelbookingApplication implements CommandLineRunner {

	@Autowired
	private HotelService hotelService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AccountService accountService;


	public static void main(String[] args) {
		SpringApplication.run(HotelbookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = roleService.createRole("ROLE_ADMIN", "Administration");
		Address address = addressService.createRAddress( 1,"1000 N st", "ddff","dfsd","dff","fd");
		//Optional<Account> account = accountService.signup("ray", "r@y100");
		//hotelService.createHotel("ray", "r@y100", role, "Hotel x", "hotel xxx", "//htsddds",address);
		//hotelService.createHotel("ray2", "r@y100", role, "Hotel HBS", "hotel hbs", "//hbs",address);

	}

}
