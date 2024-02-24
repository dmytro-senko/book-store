package dima.senko.bookstore.repositiry.book;

import dima.senko.bookstore.exception.SpecificationProviderManagerException;
import dima.senko.bookstore.model.Book;
import dima.senko.bookstore.repositiry.SpecificationProvider;
import dima.senko.bookstore.repositiry.SpecificationProviderManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProviders;

    @Override
    public SpecificationProvider<Book> getSpecification(String key) {
        return bookSpecificationProviders.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new SpecificationProviderManagerException(
                                "Can't find specification provider for key " + key));
    }
}
