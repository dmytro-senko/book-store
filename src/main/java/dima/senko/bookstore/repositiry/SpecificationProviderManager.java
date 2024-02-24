package dima.senko.bookstore.repositiry;

public interface SpecificationProviderManager<T> {

    SpecificationProvider<T> getSpecification(String key);
}
