package com.suhaibkhan.springwebfluxpoc.service;

import com.suhaibkhan.springwebfluxpoc.model.Book;
import com.suhaibkhan.springwebfluxpoc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public Mono<Book> createBook(Book book) {
        return bookRepo.save(Book.toBookEntity(book))
                .flatMap(bookEntity -> Mono.just(Book.fromBookEntity(bookEntity)));
    }

    public Flux<Book> getAllBooks() {
        return bookRepo.findAll()
                .flatMap(bookEntity -> Flux.just(Book.fromBookEntity(bookEntity)));
    }
}
