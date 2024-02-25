package dima.senko.bookstore.repository.book.spec;

import dima.senko.bookstore.model.Book;
import dima.senko.bookstore.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PriceSpecification implements SpecificationProvider<Book> {
    public static final String PRICE = "price";

    @Override
    public String getKey() {
        return PRICE;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get(PRICE).in(Arrays.stream(params).toArray());
    }
}
