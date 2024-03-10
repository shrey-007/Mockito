package org.example.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements BookRepository{
    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> newBooks=new ArrayList<>();

        Book book1=new Book("1234","Mockito in Action",500, LocalDate.now());
        Book book2=new Book("12345","JUnit 5 in Action",400, LocalDate.now());

        newBooks.add(book1);
        newBooks.add(book2);

        return newBooks;
    }
}
