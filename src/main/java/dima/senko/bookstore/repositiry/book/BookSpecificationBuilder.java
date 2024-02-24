package dima.senko.bookstore.repositiry.book;

import dima.senko.bookstore.dto.BookSearchParametersDto;
import dima.senko.bookstore.model.Book;
import dima.senko.bookstore.repositiry.SpecificationBuilder;
import dima.senko.bookstore.repositiry.SpecificationProviderManager;
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
            specification = specification.and(manager.getSpecification("author")
                    .getSpecification(authors));
        }
        String[] price = parameters.price();
        if (Objects.nonNull(price) && price.length > 0) {
            specification = specification.and(manager.getSpecification("price")
                    .getSpecification(price));
        }
        String[] titles = parameters.titles();
        if (Objects.nonNull(titles) && titles.length > 0) {
            specification = specification.and(manager.getSpecification("titles")
                    .getSpecification(titles));
        }
        String[] isbn = parameters.isbn();
        if (Objects.nonNull(isbn) && isbn.length > 0) {
            specification = specification.and(manager.getSpecification("isbn")
                    .getSpecification(isbn));
        }
        return specification;
    }
}
