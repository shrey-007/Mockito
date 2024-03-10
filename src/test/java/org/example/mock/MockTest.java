package org.example.mock;

//
//import org.example.spy.Book;
//import org.example.spy.BookService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MockTest {
    @Test
    public void demoMock(){
        BookRepositoryMock bookRepositoryMock=new BookRepositoryMock();
        BookService bookService=new BookService(bookRepositoryMock);

        Book book1=new Book("1234","Mockito in Action",500, LocalDate.now()); //this will not be saved
        Book book2=new Book("12345","JUnit 5 in Action",400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        // it is similar to spy, only difference is asserts are not made on @Test
        // instead they are made on mock level
        bookRepositoryMock.verify(book2,1);
    }
}
