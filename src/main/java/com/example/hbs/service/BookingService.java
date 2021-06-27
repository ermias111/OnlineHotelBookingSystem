package com.example.hbs.service;

import com.example.hbs.repo.BookingRepository;

public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
}
