package dima.senko.bookstore.service.impl;

import dima.senko.bookstore.dto.BookDto;
import dima.senko.bookstore.dto.CreateBookRequestDto;
import dima.senko.bookstore.exception.EntityNotFoundException;
import dima.senko.bookstore.mapper.BookMapper;
import dima.senko.bookstore.model.Book;
import dima.senko.bookstore.repositiry.BookRepository;
import dima.senko.bookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookRepository.save(bookMapper.toModel(requestDto));
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id: " + id));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto update(CreateBookRequestDto bookDto, Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id: " + id));
        Book bookToUpdate = bookMapper.toModel(bookDto);
        bookToUpdate.setId(book.getId());
        Book updatedBook = bookRepository.save(bookToUpdate);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    public BookDto delete(Long id) {
        bookRepository.deleteById(id);
        return null;
    }
}
