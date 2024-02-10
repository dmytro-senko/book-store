package dima.senko.bookstore.service;

import dima.senko.bookstore.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
