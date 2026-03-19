package com.karan.AcadZone_Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.AcadZone_Backend.model.Book;
import com.karan.AcadZone_Backend.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired private BookRepository bookRepo;

    public Book addBook(Book book){ return bookRepo.save(book); }
    public List<Book> getAllBooks(){ return bookRepo.findAll(); }
    public void deleteBook(Long id){ bookRepo.deleteById(id); }
    public List<Book> searchBooksByTitle(String title){ return bookRepo.findByTitleContainingIgnoreCase(title); }
    public List<Book> searchBooksByAuthor(String author){ return bookRepo.findByAuthorContainingIgnoreCase(author); }
}

