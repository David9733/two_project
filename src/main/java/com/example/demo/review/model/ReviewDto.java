package com.example.demo.review.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ReviewDto {

    @Getter
    @NoArgsConstructor
    @Setter
    public static class Register() {

        private String contents;
        private Integer score;
        private Integer book_idx;

        public Review toEntity(ReviewDto.Register dto) {
            Book book = Book.builder()
                    .book(dto.getBook_idx())
                    .build();


            Review entity = Review.builder()
                    .contents(this.contents)
                    .score(this.score)
                    .book(book)
                    .build();

            return entity;
        }
    }

    @Getter
    @Builder
    public static class ReviewRes {
        private Integer idx;
        private String contents;
        private Integer score;

        public static ReviewDto.ReviewRes from(Review review) {
            ReviewRes dto = ReviewRes.builder()
                    .idx(review.getIdx())
                    .contents(review.getContents())
                    .score(review.getScore())

                    .build();
            return dto;
        }
    }
}
