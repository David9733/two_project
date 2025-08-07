package com.example.demo.review.controller;

import com.example.demo.review.model.ReviewDto;
import com.example.demo.review.repository.ReviewRepository;
import com.example.demo.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody ReviewDto.Register dto){

        reviewService.register(dto);

        return ResponseEntity.status(200).body("저장완료");
    }
}
