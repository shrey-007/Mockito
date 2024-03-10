package org.example.fake;

import org.example.fake.Book;
import org.example.fake.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    //This Map is acting as a database
    Map<String, Book> bookStore=new HashMap<>();

    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(),book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
