package dima.senko.bookstore.repository.book;

import static dima.senko.bookstore.repository.book.spec.AuthorSpecification.AUTHOR;
import static dima.senko.bookstore.repository.book.spec.IsbnSpecification.ISBN;
import static dima.senko.bookstore.repository.book.spec.PriceSpecification.PRICE;
import static dima.senko.bookstore.repository.book.spec.TitleSpecification.TITLE;

import dima.senko.bookstore.dto.BookSearchParametersDto;
import dima.senko.bookstore.model.Book;
import dima.senko.bookstore.repository.SpecificationBuilder;
import dima.senko.bookstore.repository.SpecificationProviderManager;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private SpecificationProviderManager<Book> manager;

    @Override
    public Specification<Book> build(BookSearchParametersDto parameters) {
        Specification<Book> specification = Specification.where(null);
        String[] authors = parameters.authors();
        if (Objects.nonNull(authors) && authors.length > 0) {
            specification = specification.and(manager.getSpecification(AUTHOR)
                    .getSpecification(authors));
        }
        String[] price = parameters.price();
        if (Objects.nonNull(price) && price.length > 0) {
            specification = specification.and(manager.getSpecification(PRICE)
                    .getSpecification(price));
        }
        String[] titles = parameters.titles();
        if (Objects.nonNull(titles) && titles.length > 0) {
            specification = specification.and(manager.getSpecification(TITLE)
                    .getSpecification(titles));
        }
        String[] isbn = parameters.isbn();
        if (Objects.nonNull(isbn) && isbn.length > 0) {
            specification = specification.and(manager.getSpecification(ISBN)
                    .getSpecification(isbn));
        }
        return specification;
    }
}
