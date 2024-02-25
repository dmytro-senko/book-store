package dima.senko.bookstore.repositiry.book.spec;

import dima.senko.bookstore.model.Book;
import dima.senko.bookstore.repositiry.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecification implements SpecificationProvider<Book> {
    public static final String TITLE = "title";

    @Override
    public String getKey() {
        return TITLE;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get(TITLE).in(Arrays.stream(params).toArray());
    }
}
