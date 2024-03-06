package dima.senko.bookstore.service.book.impl;

import dima.senko.bookstore.dto.book.BookDto;
import dima.senko.bookstore.dto.book.BookSearchParametersDto;
import dima.senko.bookstore.dto.book.CreateBookRequestDto;
import dima.senko.bookstore.exception.EntityNotFoundException;
import dima.senko.bookstore.mapper.BookMapper;
import dima.senko.bookstore.model.Book;
import dima.senko.bookstore.repository.SpecificationBuilder;
import dima.senko.bookstore.repository.book.BookRepository;
import dima.senko.bookstore.service.book.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final SpecificationBuilder<Book> specificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookRepository.save(bookMapper.toModel(requestDto));
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
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

    @Override
    public List<BookDto> searchBooks(BookSearchParametersDto searchParameters) {
        Specification<Book> bookSpecification = specificationBuilder.build(searchParameters);
        return bookRepository.findAll(bookSpecification).stream()
                .map(bookMapper::toDto).toList();
    }
}
