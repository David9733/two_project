package com.example.demo.Book.repository;

import com.example.demo.Book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByA01(String title);
}
