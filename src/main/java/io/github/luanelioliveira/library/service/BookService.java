package io.github.luanelioliveira.library.service;

import io.github.luanelioliveira.library.dto.AddNewBook;
import io.github.luanelioliveira.library.exception.BusinessException;
import io.github.luanelioliveira.library.exception.EntityNotFoundException;
import io.github.luanelioliveira.library.model.Book;
import io.github.luanelioliveira.library.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  public void addNewBook(AddNewBook addNewBook) {
    if (bookRepository.getByIsbn(addNewBook.getIsbn()).isPresent()) {
      throw new BusinessException("This book already exists");
    }

    var book = new Book(addNewBook.getIsbn(), addNewBook.getTitle(), addNewBook.getDescription());
    bookRepository.save(book);
  }

  public List<Book> listAll() {
    return bookRepository.findAll();
  }

  public Book getByIsbn(String isbn) {
    return bookRepository
        .getByIsbn(isbn)
        .orElseThrow(() -> new EntityNotFoundException("This book already exists"));
  }
}
