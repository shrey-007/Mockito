package org.example.dummy;




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
