package org.example.mock;

//import org.example.spy.Book;
//import org.example.spy.BookRepository;

import org.junit.jupiter.api.Assertions;

public class BookRepositoryMock implements BookRepository {
    int saveCalled=0;
    Book lastAddedBook=null;
    @Override
    public void save(Book book) {
        saveCalled++;
        lastAddedBook=book;
    }

    public int timesCalled(){
        return saveCalled;
    }

    public boolean calledWith(Book book){
        return lastAddedBook.equals(book);
    }

    public void verify(Book book,int times){
        Assertions.assertEquals(times,saveCalled);
        Assertions.assertEquals(book,lastAddedBook);
    }

}
