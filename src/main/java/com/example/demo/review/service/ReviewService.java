package com.example.demo.review.service;

import com.example.demo.review.model.Review;
import com.example.demo.review.model.ReviewDto;
import com.example.demo.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public void register(ReviewDto.Register dto) {


        reviewRepository.save(dto.toEntity(dto));
    }

}
