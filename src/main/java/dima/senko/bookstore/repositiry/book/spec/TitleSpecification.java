package dima.senko.bookstore.repositiry.book.spec;

import dima.senko.bookstore.model.Book;
import dima.senko.bookstore.repositiry.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecification implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "title";
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get("title").in(Arrays.stream(params).toArray());
    }
}
