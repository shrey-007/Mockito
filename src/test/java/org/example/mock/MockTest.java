package org.example.mock;

//
//import org.example.spy.Book;
//import org.example.spy.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

    @Test
    public void demoMockWithMockito(){
        BookRepository bookRepositoryMock= Mockito.mock(BookRepository.class);
        BookService bookService=new BookService(bookRepositoryMock);

        Book book1=new Book("1234","Mockito in Action",500, LocalDate.now()); //this will not be saved
        Book book2=new Book("12345","JUnit 5 in Action",400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        // Ab tum  bookRepositoryMock.verify(book2,1); call nhi kr skte coz we are not using bookRepositoryMock class here

        // To verify whether save() was called for book2 using mockito is this
        Mockito.verify(bookRepositoryMock).save(book2);

        // This will give an exception kiuki book1 ke saath verify call hua hi nhi tha
        Mockito.verify(bookRepositoryMock).save(book1);

        // This will test whether save(book2) was called once or how many times, since it was called once so this case will pass
        Mockito.verify(bookRepositoryMock,Mockito.times(1)).save(book2);

        // This will test whether save(book1) was called zero times or how many times, since it was not called  so this case will pass
        Mockito.verify(bookRepositoryMock,Mockito.times(0)).save(book1);
    }
}
