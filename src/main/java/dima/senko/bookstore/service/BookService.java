package dima.senko.bookstore.service;

import dima.senko.bookstore.dto.BookDto;
import dima.senko.bookstore.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {

    BookDto save(CreateBookRequestDto book);

    List<BookDto> findAll();

    BookDto findBookById(Long id);
}
