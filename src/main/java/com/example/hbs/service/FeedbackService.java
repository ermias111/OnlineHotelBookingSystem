package com.example.hbs.service;

import com.example.hbs.domain.Feedback;
import com.example.hbs.repo.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getFeedbacksForAHotel(Integer hotelId){
        List<Feedback> feedbacks = feedbackRepository.findByHotelId(hotelId);

        if(feedbacks.size() == 0){
            throw new RuntimeException("No feedback for this hotel");
        }
        return feedbacks;
    }
}
