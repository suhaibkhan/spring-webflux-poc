package com.suhaibkhan.springwebfluxpoc.repository;

import com.suhaibkhan.springwebfluxpoc.model.BookEntity;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveCassandraRepository<BookEntity, BookEntity.Key> {
}
