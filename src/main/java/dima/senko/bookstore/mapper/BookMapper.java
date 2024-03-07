package dima.senko.bookstore.mapper;

import dima.senko.bookstore.config.MapperConfig;
import dima.senko.bookstore.dto.book.BookDto;
import dima.senko.bookstore.dto.book.CreateBookRequestDto;
import dima.senko.bookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);
}
