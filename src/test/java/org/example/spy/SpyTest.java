package org.example.spy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
