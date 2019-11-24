package com.bazzoli.company.company.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bazzoli.company.company.model.Book;
import com.bazzoli.company.company.repository.BookRepository;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")

public class BookController {
	private BookRepository bookRepository;

    @GetMapping("/book")
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") int bookId)
        throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + bookId));
        return ResponseEntity.ok().body(book);
    }
    
    @PostMapping("/book")
    public Book createEmployee(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateEmployee(@PathVariable(value = "id") int bookId,
         @Valid @RequestBody Book bookDetails) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

        book.setId(bookDetails.getId());
        book.setName(bookDetails.getName());
        book.setBookCategory(bookDetails.getBookCategory());
        final Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/book/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") int bookId)
         throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + bookId));

        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
