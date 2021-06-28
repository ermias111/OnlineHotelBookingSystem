package com.example.hbs;

import com.example.hbs.domain.*;
import com.example.hbs.repo.CustomerRepository;
import com.example.hbs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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

	@Autowired
	private RoomService roomService;

	@Autowired
	private RoomTypeService roomTypeService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private PaymentService paymentService;

//	@Autowired
//	public HotelbookingApplication(HotelService hotelService, AddressService addressService) {
//		this.hotelService = hotelService;
//		this.addressService = addressService;
//	}




	public static void main(String[] args) {
		SpringApplication.run(HotelbookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Address cAddress = addressService.createRAddress("Julia 4th st", "TX","Forney","43457","+123...");
		Address hAddress = addressService.createRAddress("1000 4th st", "IA","Fairfield","52557","+641...");
		Role hrole = roleService.createRole("Hotel", "HotelRole");
		Role crole = roleService.createRole("Customer", "CustomerRole");
		Hotel hotel = hotelService.createHotel("hilton12", "1234", hrole, "Hilton", "5 star", "img/1.jpg",hAddress);
		Customer customer = customerService.createCustomer("jj", "1234", crole,"James", "Joseph", "j@gmail.com", cAddress);
		RoomType standard = roomTypeService.createRoomType("Standard", "1 master bedroom"
				, "img/s.jpg", 300.00, hotel);
		RoomType king = roomTypeService.createRoomType("King", "2 master bedroom"
				, "img/e.jpg", 400.00, hotel);

		Room r1 = roomService.createRoom(100, true, hotel, standard);
		Room r2 = roomService.createRoom(101, true, hotel, king);
		Room r3 = roomService.createRoom(102, true, hotel, standard);

		Payment payment = paymentService.createPayment(customer, 123123123878976L, new Date(2021, 9, 2), 1000.0);
		bookingService.createBooking(new Date(2021, 9, 1), new Date(2021, 9, 4)
				                   , customer, Arrays.asList(r1, r2, r3), payment);


	}

}
