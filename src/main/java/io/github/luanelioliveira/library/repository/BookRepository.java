package io.github.luanelioliveira.library.repository;

import io.github.luanelioliveira.library.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {

  Book save(Book book);

  Optional<Book> getByIsbn(String isbn);

  List<Book> findAll();
}
