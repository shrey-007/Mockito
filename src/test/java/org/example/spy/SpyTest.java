package org.example.spy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class SpyTest {
    @Test
    public void demoSpy(){
        BookRepositorySpy bookRepositorySpy=new BookRepositorySpy();
        BookService bookService=new BookService(bookRepositorySpy);

        Book book1=new Book("1234","Mockito in Action",500, LocalDate.now());
        Book book2=new Book("12345","JUnit 5 in Action",400, LocalDate.now());

        // addBook method src folder mai hai toh vaha jaaega add krne but vaha condition lagi hai ki book tabhi
        // add hogi jab uski cost less than 400 hogi toh book1 add nhi hogi toh apan ko kahi se bhi pata nhi padega
        // ki konsi book add ho rhi hai konsi nhi means apan track nhi rakh paaege
        // toh track rakhne ke liye 2 variable use kre hai numberOfTime saved method is called and last saved book
        // toh ye test fail hoga

//        TESTCASE 1 ==================================================>
//        bookService.addBook(book1);
//        bookService.addBook(book2);
//
//        Assertions.assertEquals(2,bookRepositorySpy.timesCalled());
//        Assertions.assertTrue(bookRepositorySpy.calledWith(book2));


        // But agar tum ise daalo test case mai toh vo paas hoga

//        TESTCASE 2 ==================================================>
//        bookService.addBook(book1);
//        Assertions.assertEquals(0,bookRepositorySpy.timesCalled());
//
//        bookService.addBook(book2);
//        Assertions.assertEquals(1,bookRepositorySpy.timesCalled());


    }

    @Test
    public void demoSpyWithMockito(){
        BookRepository bookRepositorySpy= Mockito.spy(BookRepository.class);
        BookService bookService=new BookService(bookRepositorySpy);

        Book book1=new Book("1234","Mockito in Action",500, LocalDate.now()); //this will not be saved
        Book book2=new Book("12345","JUnit 5 in Action",400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        // Ab tum  bookRepositoryMock.verify(book2,1); call nhi kr skte coz we are not using bookRepositoryMock class here

        // To verify whether save() was called for book2 using mockito is this
        Mockito.verify(bookRepositorySpy).save(book2);

        // This will give an exception kiuki book1 ke saath verify call hua hi nhi tha
        Mockito.verify(bookRepositorySpy).save(book1);

        // This will test whether save(book2) was called once or how many times, since it was called once so this case will pass
        Mockito.verify(bookRepositorySpy,Mockito.times(1)).save(book2);

        // This will test whether save(book1) was called zero times or how many times, since it was not called  so this case will pass
        Mockito.verify(bookRepositorySpy,Mockito.times(0)).save(book1);
    }
}
