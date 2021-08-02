package io.github.luanelioliveira.library.repository;

import io.github.luanelioliveira.library.model.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookRepository implements BookRepository {

  private Map<String, Book> BOOKS = new HashMap<>();

  @Override
  public Book save(Book book) {
    BOOKS.put(book.getIsbn(), book);
    return book;
  }

  @Override
  public Optional<Book> getByIsbn(String isbn) {
    return Optional.ofNullable(BOOKS.get(isbn));
  }

  @Override
  public List<Book> findAll() {
    return new ArrayList<>(BOOKS.values());
  }
}
