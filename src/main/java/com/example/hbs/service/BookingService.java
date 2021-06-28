package com.example.hbs.service;

import com.example.hbs.domain.Booking;
import com.example.hbs.domain.Customer;
import com.example.hbs.domain.Payment;
import com.example.hbs.domain.Room;
import com.example.hbs.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     * Create new booking
     * @param check_in
     * @param check_out
     * @param customer
     * @param rooms
     * @return
     */
    public Booking createBooking(Date check_in, Date check_out, Customer customer, List<Room> rooms, Payment p){
        return null;
    }

    /**
     * Get reservations for a customer
     * @param customerId
     * @return
     */
    public List<Booking> getBookingForACustomer(Integer customerId){
        //check for customer existence

        List<Booking> reservations = bookingRepository.findByCustomerId(customerId);

        if(reservations.size() == 0){
            throw new RuntimeException("No reservation");
        }

        return reservations;
    }

    /**
     * Get list of reservations for a hotel
     * @param hotelId
     * @return
     */
    public List<Booking> getBookingForAHotel(Integer hotelId){
        List<Booking> reservations = bookingRepository.findByRooms_HotelId(hotelId);

        if(reservations.size() == 0){
            throw new RuntimeException("No reservation");
        }

        return reservations;
    }



}
