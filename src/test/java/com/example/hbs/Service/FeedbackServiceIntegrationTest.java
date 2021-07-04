package com.example.hbs.Service;

import com.example.hbs.domain.*;
import com.example.hbs.service.FeedbackService;
import com.example.hbs.service.HotelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FeedbackServiceIntegrationTest {
    @Autowired
    private FeedbackService feedbackService;
//
    Hotel hotel = new Hotel("Hotel Y", "5 star", "/img/ds.jpg", new Address());
    Customer customer = new Customer("Test123", "1234", new Role(), "Hais", "Gwes");
//
//
    @Test
    public void createFeedback(){
//        Feedback feedback = feedbackService.createFeedback("That's good", customer, hotel);
//        assertNull(feedback);
//        assertThat(feedback.getHotel().getName(), is("Hotel Y"));
//        assertThat(feedback.getCustomer().getFirstname(), is("Hais"));
    }
}
