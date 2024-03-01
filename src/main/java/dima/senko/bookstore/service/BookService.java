package dima.senko.bookstore.service;

import dima.senko.bookstore.dto.BookDto;
import dima.senko.bookstore.dto.BookSearchParametersDto;
import dima.senko.bookstore.dto.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {

    BookDto save(CreateBookRequestDto book);

    List<BookDto> findAll(Pageable pageable);

    BookDto findBookById(Long id);

    BookDto update(CreateBookRequestDto bookDto, Long id);

    BookDto delete(Long id);

    List<BookDto> searchBooks(BookSearchParametersDto searchParameters);
}
