package org.example.fake;

import org.example.fake.Book;

import java.util.Collection;

public interface BookRepository {
    void save(Book book);

    Collection<Book> findAll();
}
