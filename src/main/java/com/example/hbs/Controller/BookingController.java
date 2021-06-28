package com.example.hbs.Controller;

import com.example.hbs.domain.Room;
import com.example.hbs.others.BookingForm;
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
    public List<Room> setBooking(@RequestBody BookingForm bookingForm){
        return roomService.getFreeRoomAndBook(
                    bookingForm.getRoomTypeId(),
                    bookingForm.getNumberOfRooms(),
                    bookingForm.getCustomerId(),
                    bookingForm.getCheckIn(),
                    bookingForm.getCheckOut(),
                    bookingForm.getCardNum(),
                    bookingForm.getPaymentDate());
    }
}
