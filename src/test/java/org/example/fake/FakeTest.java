package org.example.fake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FakeTest {
    @Test
    public void testFake(){
        //BookRepository is an interface uska object nhi bana skte
        // FakeBookRepository is a class which implements BookRepository toh uska object bana skte hai
        BookRepository bookRepository=new FakeBookRepository();
        BookService bookService=new BookService(bookRepository);

        bookService.addBook(new Book("1234","Mockito in Action",250, LocalDate.now()));
        bookService.addBook(new Book("12345","JUnit 5 in Action",200, LocalDate.now()));

        //We have created two books so database should have stored two books so we can test it using assert
        Assertions.assertEquals(2,bookService.findNumberOfBooks());

    }
}
