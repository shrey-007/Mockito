package org.example.stub;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // ye voh method hai jisme tum days doge let 7 toh books jo 7 din pehle publish hue hai unki list aa jaaegi then vo
    // un saari books pr discount laga dega discountRate ka.
    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){

      List<Book> newBooks=bookRepository.findNewBooks(days);

      for(Book book : newBooks){
          int price=book.getPrice();
          int newPrice=price-(discountRate*price/100);
          book.setPrice(newPrice);
      }
      return newBooks;
    }

}
