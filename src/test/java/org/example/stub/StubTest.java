package org.example.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StubTest {
    @Test
    public void demoStub(){

        BookRepository bookRepository=new BookRepositoryStub();
        BookService bookService=new BookService(bookRepository);

        // hoga kya ki ye jaaega BookService class pr main mai and fir vaha vo internall call karega BookRepositoryStub
        // ko to get list of all books (database) then BookService kuch computaions kregi and data yaha bhej degi
        List<Book> newBooksWithAppliedDiscount=bookService.getNewBooksWithAppliedDiscount(10,7);

        Assertions.assertEquals(2,newBooksWithAppliedDiscount.size());

        Assertions.assertEquals(450,newBooksWithAppliedDiscount.get(0).getPrice());

        Assertions.assertEquals(360,newBooksWithAppliedDiscount.get(1).getPrice());


    }

    @Test
    public void demoStubWithMockito(){

        // We need BookRepository type object coz vo interface hai uska object nhi banega toh humne BookRepositorySub
        // banaya but fir usme hume khud se kaafi cheeje krni padi since hume object chaiye toh mockito se lelete hai
        BookRepository bookRepository= Mockito.mock(BookRepository.class);
        BookService bookService=new BookService(bookRepository);

        // Since pehle apan ke paas BookRepositoryStub tha toh usne findNewBooks method implement kra tha but abhi apan
        // BookRepositoryStub use nhi kr rhe toh jab findNewBooks() call hoga toh kya krna hai ye nhi bataya

        Book book1=new Book("1234","Mockito in Action",250, LocalDate.now());
        Book book2=new Book("12345","JUnit 5 in Action",200, LocalDate.now());

        List<Book> books=new ArrayList<>();
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(books);

        List<Book> newBooksWithAppliedDiscount=bookService.getNewBooksWithAppliedDiscount(10,7);

        Assertions.assertEquals(2,newBooksWithAppliedDiscount.size());

        Assertions.assertEquals(450,newBooksWithAppliedDiscount.get(0).getPrice());

        Assertions.assertEquals(360,newBooksWithAppliedDiscount.get(1).getPrice());


    }
}
