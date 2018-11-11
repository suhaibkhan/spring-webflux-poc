package com.suhaibkhan.springwebfluxpoc.controller;

import com.suhaibkhan.springwebfluxpoc.model.Book;
import com.suhaibkhan.springwebfluxpoc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Mono<ResponseEntity<Book>> createBook(@RequestBody Book book) {
        return bookService.createBook(book)
                .map(createdBook -> new ResponseEntity<>(createdBook, HttpStatus.CREATED));
    }

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

}
