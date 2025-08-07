package com.example.demo.Book.service;

import com.example.demo.Book.model.Book;
import com.example.demo.Book.model.BookDto;
import com.example.demo.Book.repository.BookRepository;
import com.example.demo.a.model.A;
import com.example.demo.a.model.ADto;
import com.example.demo.a.repository.ARepository;
import com.example.demo.b.model.BDto;
import com.example.demo.b.repository.BRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ReivewRepository reivewRepository;

    public void register(BookDto.Register dto) {
        Book book = BookRepository.save(dto.toEntity());

        for(ReviewDto.Register reviewDto : dto.getBook()){
            ReivewRepository.save(reviewDto.toEntity(book));
        }
    }

    public List<BookDto.BookRes> list() {
        List<Book> result = bookRepository.findAll();

        return result.stream().map(BookDto.BookRes::from).toList();
    }

    public BookDto.BookRes read(Integer idx) {
        Optional<Book> result = bookRepository.findById(idx);

        if (result.isPresent()) {
            Book entity = result.get();

            return BookDto.BookRes.from(entity);
        }

        return null;
    }

    public List<BookDto.BookRes> search(String title) {
        List<Book> result = bookRepository.findByTitle(title);

        return result.stream().map(BookDto.BookRes::from).toList();
    }
}
