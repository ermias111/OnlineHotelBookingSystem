package com.example.hbs.web;


import com.example.hbs.domain.Feedback;
import com.example.hbs.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/feedbacks")
public class FeedbackController {
    private FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public void postFeedback(@RequestBody Feedback feedback){
        feedbackService.createFeedback(
                feedback.getComment(),
                feedback.getCustomer(),
                feedback.getHotel()
                );
    }

    @GetMapping(path = "{hotelId}")
    public List<Feedback> getHotelFeedback(@RequestParam Integer hotelId){
        return feedbackService.getFeedbacksForAHotel(hotelId);
    }

}
