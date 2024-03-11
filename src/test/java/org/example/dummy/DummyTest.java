package org.example.dummy;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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

    @Test
    public void demoDummyWithMockito(){

        //  use mockito to create bookRepository to interact with database
        BookRepository bookRepository= Mockito.mock(BookRepository.class);

        // use mockito to create a dummy test double of email service
        // Pehle apan ko faaltu mai ek extra class banani padi thi DummyEmailService and usme methods implement krne pade
        // faaltu mai jinki jarurat bhi nhi thi, but yah aek line mai kaam ho gya. Mehtods implement nhi krne pade
        // Is baar apan DummyEmailService us nhi kr rhe , mockito use kr rhe hai
        EmailService emailService=Mockito.mock(EmailService.class);

        BookService bookService=new BookService(bookRepository,emailService);

        // Add books
        Collection<Book> books=new ArrayList<>();
        Book book1=new Book("1234","Mockito in Action",250, LocalDate.now());
        Book book2=new Book("12345","JUnit 5 in Action",200, LocalDate.now());
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        Assertions.assertEquals(2,bookService.findNumberOfBooks());


    }
}
