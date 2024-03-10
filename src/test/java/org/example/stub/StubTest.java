package org.example.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StubTest {
    @Test
    public void demoStub(){

        BookRepository bookRepository=new BookRepositoryStub();
        BookService bookService=new BookService(bookRepository);

        List<Book> newBooksWithAppliedDiscount=bookService.getNewBooksWithAppliedDiscount(10,7);

        Assertions.assertEquals(2,newBooksWithAppliedDiscount.size());

        Assertions.assertEquals(450,newBooksWithAppliedDiscount.get(0).getPrice());

        Assertions.assertEquals(360,newBooksWithAppliedDiscount.get(1).getPrice());


    }
}
