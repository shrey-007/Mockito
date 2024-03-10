package org.example.dummy;

public class BookService {
    //it interacts with database
    private BookRepository bookRepository;

    //It sends an email
    private EmailService emailService;

    public BookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
        this.emailService = emailService;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public int findNumberOfBooks(){
        return bookRepository.findAll().size();
    }


}
