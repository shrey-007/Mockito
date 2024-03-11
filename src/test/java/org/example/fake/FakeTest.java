package org.example.fake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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

    @Test
    public void testFakeWithMockito(){
        /* Dekho BookService is a class under Test toh uske functions sahi kaam kr rhe hai ki nhi ya nhi ye check kr rhe hai
           But it is can not ne tested directly coz vo depend kr rha tha bookrepository pr toh bookrepository ka object chaiye tha

           1) Toh humne FakeBookRepository bana diya jisme ArrayList mai store krke return krdi values
           2) Humne Mockito use kra to get bookRepository  toh is baar FakeBookRepository ka kuch kaam nhi hai.

        */

        // It is dependency toh mockito se iska object banaya
        BookRepository bookRepository= Mockito.mock(BookRepository.class);
        //It is class under test toh iska object toh banana hi padega
        BookService bookService=new BookService(bookRepository);


        //Now we added two books in our collection or so called database
        Book book1=new Book("1234","Mockito in Action",250, LocalDate.now());
        Book book2=new Book("12345","JUnit 5 in Action",200, LocalDate.now());

        Collection<Book> books=new ArrayList<>();
        books.add(book1);
        books.add(book2);

        // Since pichli baar FakeBookRepository class thi toh usme implement kr diya tha findAll method

        // But is baar kisi class ka use nhi kr rhe toh mockito ko batana padega ki agar hum findAll() method call kre
        // toh books ki arraylist return kr dena

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        Assertions.assertEquals(2,bookService.findNumberOfBooks());


    }
}
