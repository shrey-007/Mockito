package org.example.dummy;


import dummy.Book;
import dummy.BookRepository;
import dummy.BookService;
import dummy.EmailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DummyTest {
    @Test
    public void demoDummy(){
        //BookRepository is an interface uska object nhi bana skte
        // FakeBookRepository is a class which implements BookRepository toh uska object bana skte hai
        BookRepository bookRepository=new FakeBookRepository();
        EmailService emailService=new DummyEmailService();

        // bookservice ke constructor 2 arguments maang rha hai bookrepository and emailservice
        // bookrepository database se interact kr rha tha toh uske liye fake object bana liya but email service  email
        // bhej rha hai but voh abhi required nhi hai email bhejna hume bas database vaala part check krna hai but since
        // constructor use maang rha hai argument mai, toh uska dummy object bana do and use pass krdo just to avoid compilation error

        BookService bookService=new BookService(bookRepository, emailService);

        bookService.addBook(new Book("1234","Mockito in Action",250, LocalDate.now()));
        bookService.addBook(new Book("12345","JUnit 5 in Action",200, LocalDate.now()));

        //We have created two books so database should have stored two books so we can test it using assert
        Assertions.assertEquals(2,bookService.findNumberOfBooks());

    }
}
