package com.example.hbs.repo;

import com.example.hbs.domain.*;
import com.example.hbs.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomRepositoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomRepositoryTest.class);

    @MockBean
    private RoomRepository roomRepository;

    @Test
    public void findFreeRoomOfAHotel(){
//        RoomType rt = new RoomType();
//        Room room1 = new Room(201, true, new Hotel(), rt);
////        roomService.createRoom(202, true, hotel, standard);
////        roomService.createRoom(203, true, hotel, standard);
//        int numberOfFreedoms = roomRepository.findByRoomTypeIdAndVacantTrue(rt.getId()).size();
////        LOGGER.info(numberOfFreedoms + " hhhhhhhh");
//        assertThat(numberOfFreedoms, is(1));
    }
}
