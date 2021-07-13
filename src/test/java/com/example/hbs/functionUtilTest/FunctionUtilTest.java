package com.example.hbs.functionUtilTest;

import com.example.hbs.domain.*;
import com.example.hbs.functionUtil.FunctionUtil;
import org.junit.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

public class FunctionUtilTest {

    List<Hotel> hotels = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    Customer tom, david, joseph;
    Hotel hx, hy, hz;
    RoomType standardHx, deluxHx, suiteHx, standardHy, deluxHy, suiteHy, standardHz, deluxHz, suiteHz;
    Room rm1_hx, rm1_hy, rm1_hz
            , rm2_hx, rm2_hy, rm2_hz
            , rm3_hx, rm3_hy, rm3_hz
            , rm4_hx, rm4_hy, rm4_hz
            , rm5_hx, rm5_hy, rm5_hz
            , rm6_hx, rm6_hy, rm6_hz;

    LocalDateTime baseTime = LocalDateTime.now();

    Booking tomBooking1, tomBooking2
            , davidBooking1, davidBooking2, davidBooking3
            , josephBooking1;


    @Before
    public void setup(){
        // Hotel 1
        hx = new Hotel("hx", "5 star", "img/hx.jpg", new Address("1000 4th", "IA", "Fairfield", "52557", "6411234543"));
        standardHx = new RoomType("Standard", "1 bedrooms", "rm_hx1.jpg", 200.00, hx);
        deluxHx = new RoomType("Delux", "2 bedrooms", "rm_hx1.jpg", 300.00, hx);
        suiteHx = new RoomType("Suite", "3 bedrooms", "rm_hx1.jpg", 400.00, hx);
        rm1_hx = new Room(100, true, hx, standardHx);
        rm2_hx = new Room(101, true, hx, standardHx);
        rm3_hx = new Room(102, true, hx, deluxHx);
        rm4_hx = new Room(103, true, hx, deluxHx);
        rm5_hx = new Room(104, true, hx, suiteHx);
        rm6_hx = new Room(105, true, hx, suiteHx);

        hx.addRoomTypes(Arrays.asList(standardHx, deluxHx, suiteHx));
        standardHx.addRooms(Arrays.asList(rm1_hx, rm2_hx));
        deluxHx.addRooms(Arrays.asList(rm3_hx, rm4_hx));
        suiteHx.addRooms(Arrays.asList(rm5_hx, rm6_hx));



        hy = new Hotel("hy", "5 star", "img/hy.jpg", new Address("1000 4th", "NY", "Buffalo", "21234", "323435678"));
        standardHy = new RoomType("Standard", "1 bedrooms", "rm_hy1.jpg", 200.00, hy);
        deluxHy = new RoomType("Delux", "2 bedrooms", "rm_hy1.jpg", 300.00, hy);
        suiteHy = new RoomType("Suite", "3 bedrooms", "rm_hy1.jpg", 400.00, hy);
        rm1_hy = new Room(100, true, hy, standardHy);
        rm2_hy = new Room(101, true, hy, standardHy);
        rm3_hy = new Room(102, true, hy, deluxHy);
        rm4_hy = new Room(103, true, hy, deluxHy);
        rm5_hy = new Room(104, true, hy, suiteHy);
        rm6_hy = new Room(105, true, hy, suiteHy);

        hy.addRoomTypes(Arrays.asList(standardHy, deluxHy, suiteHy));
        standardHy.addRooms(Arrays.asList(rm1_hy, rm2_hy));
        deluxHy.addRooms(Arrays.asList(rm3_hy, rm4_hy));
        suiteHy.addRooms(Arrays.asList(rm5_hy, rm6_hy));


        hz = new Hotel("hz", "5 star", "img/hz.jpg", new Address("1000 4th", "IA", "Iowa city", "52897", "641123423"));
        standardHz = new RoomType("Standard", "1 bedrooms", "rm_hz1.jpg", 200.00, hz);
        deluxHz = new RoomType("Delux", "2 bedrooms", "rm_hz1.jpg", 300.00, hz);
        suiteHz = new RoomType("Suite", "3 bedrooms", "rm_hz1.jpg", 400.00, hz);
        rm1_hz = new Room(100, true, hz, standardHz);
        rm2_hz = new Room(101, true, hz, standardHz);
        rm3_hz = new Room(102, true, hz, deluxHz);
        rm4_hz = new Room(103, true, hz, deluxHz);
        rm5_hz = new Room(104, true, hz, suiteHz);
        rm6_hz = new Room(105, true, hz, suiteHz);

        hz.addRoomTypes(Arrays.asList(standardHz, deluxHz, suiteHz));
        standardHz.addRooms(Arrays.asList(rm1_hz, rm2_hz));
        deluxHz.addRooms(Arrays.asList(rm3_hz, rm4_hz));
        suiteHz.addRooms(Arrays.asList(rm5_hz, rm6_hz));


        tom = new Customer("Tom", "Bailer", "tbaile@gmail.com");
        david = new Customer("david", "john", "djohn@gmail.com");
        joseph = new Customer("joseph", "lerman", "jlerman@gmail.com");


        //Bookings
        tomBooking1 = new Booking(baseTime, baseTime.plusDays(3), tom, Arrays.asList(rm1_hx),
                new Payment(tom, "1234567889", baseTime, 200.00));
        tomBooking2 = new Booking(baseTime.plusMonths(1), baseTime.plusMonths(1).plusDays(3), tom, Arrays.asList(rm2_hx),
                new Payment(tom, "1234567889", baseTime, 200.00));
        davidBooking1 = new Booking(baseTime.plusMonths(1), baseTime.plusMonths(1).plusDays(3), david, Arrays.asList(rm3_hy),
                new Payment(david, "1234567889", baseTime, 400.00));
        davidBooking2 = new Booking(baseTime.plusMonths(1), baseTime.plusMonths(1).plusDays(3), david, Arrays.asList(rm3_hx),
                new Payment(david, "1234567889", baseTime, 300.00));
        josephBooking1 = new Booking(baseTime.plusMonths(1), baseTime.plusMonths(1).plusDays(3), joseph, Arrays.asList(rm4_hx),
                new Payment(joseph, "1234567889", baseTime, 300.00));



        hotels.addAll(Arrays.asList(hx, hy, hz));
        customers.addAll(Arrays.asList(tom, david, joseph));
    }
}
