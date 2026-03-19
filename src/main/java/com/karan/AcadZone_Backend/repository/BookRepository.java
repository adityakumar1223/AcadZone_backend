package com.karan.AcadZone_Backend.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karan.AcadZone_Backend.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);  // Search book by title
    List<Book> findByAuthorContainingIgnoreCase(String author);// Search book by author
}
