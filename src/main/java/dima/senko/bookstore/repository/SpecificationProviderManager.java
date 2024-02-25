package dima.senko.bookstore.repository;

public interface SpecificationProviderManager<T> {
    SpecificationProvider<T> getSpecification(String key);
}
