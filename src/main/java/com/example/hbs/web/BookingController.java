package com.example.hbs.web;

import com.example.hbs.domain.Room;
import com.example.hbs.web.BookingDto;
import com.example.hbs.service.BookingService;
import com.example.hbs.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "booking")
public class BookingController {
    private final BookingService bookingService;
    private final RoomService roomService;

    @Autowired
    public BookingController(BookingService bookingService, RoomService roomService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
    }

    @PostMapping(path = "/book")
    public List<Room> setBooking(@RequestBody BookingDto bookingDto){
        return roomService.getFreeRoomAndBook(
                    bookingDto.getRoomTypeId(),
                    bookingDto.getNumberOfRooms(),
                    bookingDto.getCustomerId(),
                    bookingDto.getCheckIn(),
                    bookingDto.getCheckOut(),
                    bookingDto.getCardNum(),
                    bookingDto.getPaymentDate());
    }
}
