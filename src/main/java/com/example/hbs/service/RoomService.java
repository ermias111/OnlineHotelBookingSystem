package com.example.hbs.service;

import com.example.hbs.domain.*;
import com.example.hbs.repo.CustomerRepository;
import com.example.hbs.repo.HotelRepository;
import com.example.hbs.repo.RoomRepository;
import com.example.hbs.repo.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class RoomService {
    private  RoomRepository roomRepository;
    private RoomTypeRepository roomTypeRepository;
    private HotelRepository hotelRepository;
    private BookingService bookingService;
    private PaymentService paymentService;
    private CustomerRepository customerRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomTypeRepository roomTypeRepository
            ,HotelRepository hotelRepository, BookingService bookingService,PaymentService paymentService
            ,CustomerRepository customerRepository) {
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.hotelRepository = hotelRepository;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
        this.customerRepository = customerRepository;
    }

    public Room createRoom(Integer room_number, Boolean vacant, Hotel hotel, RoomType roomType){
        return roomRepository.findByRoomTypeIdAndRoomNumber(roomType.getId(), room_number)
                .orElse(roomRepository.save(new Room(room_number, vacant, hotel, roomType)));
    }

    @Transactional
    public Room bookRoom(Integer roomId){
        Room room = roomRepository.findById(roomId).orElseThrow(() ->
                new RuntimeException("Room not available"));

        room.setVacant(false);
        return room;
    }


    /**
     * Get a free room of type T and
     * book
     * @param roomTypeId
     */
    public List<Room> getFreeRoomAndBook(Integer roomTypeId, Integer numberOfRooms, Integer customerId
                                    , Date checkIn, Date checkOut, Long cardNum, Date paymentDate){
        List<Room> rooms = roomRepository.findByRoomTypeIdAndVacantTrue(roomTypeId);

        if(rooms.size() == 0){
            throw new RuntimeException("All rooms with this type are reserved");
        }else if(numberOfRooms > rooms.size()){
            throw new RuntimeException("We don't have enough rooms with your requirement");
        }

        Collections.sort(rooms, new Comparator<Room>() {
            @Override
            public int compare(Room r1, Room r2) {
                return Integer.compare(r1.getRoomNumber(),r2.getRoomNumber());
            }
        });

        Double totalPrice = 0.0;
        Room r = new Room();
        List<Room> reservedRooms = new ArrayList<>();
        for(int i = 0; i < numberOfRooms; i++){
            r = rooms.get(i);
            reservedRooms.add(bookRoom(r.getId()));
            totalPrice += r.getRoomType().getPrice();
        }

        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->
                new RuntimeException("User not available"));
        Payment payment1 = paymentService.createPayment(customer, cardNum, paymentDate, totalPrice);
        bookingService.createBooking(checkIn, checkOut, customer, reservedRooms, payment1);
        return reservedRooms;
    }


    /**
     * Free room after the customer check out
     * @param roomId
     */
    @Transactional
    public void freeRoom(Integer roomId){
        Room room = roomRepository.findById(roomId).orElseThrow(() ->
                new RuntimeException("room does not exist")
        );

        room.setVacant(true);
    }

    /**
     * Lookup All Tour packages
     *
     * @return
     */
    public Iterable<Room> lookup(){
        return roomRepository.findAll();
    }

    public long total() {
        return roomRepository.count();
    }
}
