package com.suhaibkhan.springwebfluxpoc.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Table("books")
public class BookEntity {

    @PrimaryKeyClass
    public static class Key implements Serializable {

        @PrimaryKeyColumn(name="published_year", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
        private int publishedYear;

        @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
        private String author;

        @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
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

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "publishedYear=" + publishedYear +
                    ", author='" + author + '\'' +
                    ", isbn='" + isbn + '\'' +
                    '}';
        }
    }

    @PrimaryKey
    private BookEntity.Key key;

    private String name;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "key=" + key +
                ", name='" + name + '\'' +
                '}';
    }
}
