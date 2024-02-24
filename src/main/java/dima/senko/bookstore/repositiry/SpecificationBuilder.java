package dima.senko.bookstore.repositiry;

import dima.senko.bookstore.dto.BookSearchParametersDto;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {

    Specification<T> build(BookSearchParametersDto searchParametersDto);
}
