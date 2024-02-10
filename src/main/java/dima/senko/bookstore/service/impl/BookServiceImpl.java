package dima.senko.bookstore.service.impl;

import dima.senko.bookstore.model.Book;
import dima.senko.bookstore.repositiry.BookRepository;
import dima.senko.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
