package com.example.hbs.service;

import com.example.hbs.domain.Customer;
import com.example.hbs.domain.Feedback;
import com.example.hbs.domain.Hotel;
import com.example.hbs.repo.FeedbackRepository;
import com.example.hbs.repo.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private FeedbackRepository feedbackRepository;
    private HotelRepository hotelRepository;

    public FeedbackService(FeedbackRepository feedbackRepository, HotelRepository hotelRepository) {
        this.feedbackRepository = feedbackRepository;
        this.hotelRepository = hotelRepository;
    }

    /**
     *
     * @param hotelId
     * @return
     */
    public List<Feedback> getFeedbacksForAHotel(Integer hotelId){
        hotelRepository.findById(hotelId).orElseThrow(() ->
                new RuntimeException("hotel doesn't exist")
        );

        List<Feedback> feedbacks = feedbackRepository.findByHotelId(hotelId);

        if(feedbacks.size() == 0){
            throw new RuntimeException("No feedback for this hotel");
        }
        return feedbacks;
    }

    /**
     *
     * @param comment
     * @param customer
     * @param hotel
     */
    public Feedback createFeedback(String comment, Customer customer, Hotel hotel){
        hotelRepository.findById(hotel.getId()).orElseThrow(() ->
                    new RuntimeException("hotel doesn't exist")
                );
        return feedbackRepository.save(new Feedback(comment, customer, hotel));
    }
}
