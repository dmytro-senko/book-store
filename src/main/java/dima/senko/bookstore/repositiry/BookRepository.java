package dima.senko.bookstore.repositiry;

import dima.senko.bookstore.model.Book;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
