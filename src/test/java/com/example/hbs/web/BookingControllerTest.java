package com.example.hbs.web;


import com.example.hbs.domain.Customer;
import com.example.hbs.domain.Hotel;
import com.example.hbs.domain.Room;
import com.example.hbs.domain.RoomType;
import com.example.hbs.repo.HotelRepository;
import com.example.hbs.repo.RoomTypeRepository;
import com.example.hbs.service.BookingService;
import com.example.hbs.service.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpMethod.POST;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingControllerTest {
    @MockBean
    private RoomService roomService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JwtRequestHelper jwtRequestHelper;


    @MockBean
    private RoomTypeRepository roomTypeRepository;

    @MockBean
    private HotelRepository hotelRepository;

    BookingDto bookingDto = new BookingDto(1, 1,
            2, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()),
            "8273847293", new Date(System.currentTimeMillis()));

    // FIX THIS
    Room room = new Room(122, true, new Hotel(),new RoomType());


    @Test
    public void createBooking(){
        when(roomService.getFreeRoomAndBook(bookingDto.getRoomTypeId(), bookingDto.getNumberOfRooms(), bookingDto.getCustomerId(), bookingDto.getCheckIn(),
                bookingDto.getCheckOut(), bookingDto.getCardNum(), bookingDto.getPaymentDate())).thenReturn(Arrays.asList(room));

        ResponseEntity<List<Room>> response = restTemplate.exchange("/bookings/book",
                POST,
                new HttpEntity(bookingDto,jwtRequestHelper.withRole("Customer")),
                new ParameterizedTypeReference<List<Room>>() {});

        assertThat(response.getStatusCode().value(), is(200));
        assertThat(response.getBody().get(0).getRoomType().getId(), is(bookingDto.getRoomTypeId()));
//        assertThat(response.getBody().getFirstname(), is(user.getFirstname()));
//        assertThat(response.getBody().getLastname(), is(user.getLastname()));
//        assertThat(response.getBody().getRole(), is(user.getRole()));
    }
}
