package com.example.demo.Book.model;


import com.example.demo.b.model.BDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class BookDto {

    @Getter
    public static class Register {
        private String title;
        private Integer page;
        private Integer price;
        private List<BookDto.Register> book;

        public Book toEntity() {
            Book entity = Book.builder()
                    .title(title)
                    .page(page)
                    .price(price)
                    .build();
            return entity;
        }
    }
    @Getter
    @Builder
    public static class BookRes {
        private Integer idx;
        private String title;
        private Integer page;
        private Integer price;
        private List<ReviewDto.ReviewRes> bResList;

        public static BookRes from(Book entity) {
            BookRes dto = BookRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .page(entity.getPage())
                    .price(entity.getPrice())
                    .reviewResList(entity.getReviewList().stream().map(ReviewDto.ReviewRes::from).toList())
                    .build();


            return dto;
        }
    }

}
