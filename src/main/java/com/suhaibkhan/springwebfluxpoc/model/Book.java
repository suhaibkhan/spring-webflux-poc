package com.suhaibkhan.springwebfluxpoc.model;

public class Book {

    private int publishedYear;

    private String author;

    private String name;

    private String isbn;

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "publishedYear=" + publishedYear +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public static Book fromBookEntity(final BookEntity bookEntity) {
        final Book book = new Book();
        book.setPublishedYear(bookEntity.getKey().getPublishedYear());
        book.setAuthor(bookEntity.getKey().getAuthor());
        book.setIsbn(bookEntity.getKey().getIsbn());
        book.setName(bookEntity.getName());
        return book;
    }

    public static BookEntity toBookEntity(final Book book) {
        final BookEntity bookEntity = new BookEntity();
        final BookEntity.Key key = new BookEntity.Key();
        key.setPublishedYear(book.getPublishedYear());
        key.setAuthor(book.getAuthor());
        key.setIsbn(book.getIsbn());
        bookEntity.setKey(key);
        bookEntity.setName(book.getName());
        return bookEntity;
    }
}
