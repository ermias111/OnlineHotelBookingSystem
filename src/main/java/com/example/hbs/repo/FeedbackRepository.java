package com.example.hbs.repo;

import com.example.hbs.domain.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
    @Override
    Optional<Feedback> findById(Integer integer);

    List<Feedback> findByHotelId(Integer hotelId);
}
