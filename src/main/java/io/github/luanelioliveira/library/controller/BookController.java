package io.github.luanelioliveira.library.controller;

import io.github.luanelioliveira.library.model.Book;
import io.github.luanelioliveira.library.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @PostMapping
  public ResponseEntity<?> addNewBook(@RequestBody AddNewBookRequest request) {
    bookService.addNewBook(request.toCommand());
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public List<Book> findAllBooks() {
    return bookService.listAll();
  }

  @GetMapping("{isbn}")
  public Book getByIsbn(@PathVariable String isbn) {
    return bookService.getByIsbn(isbn);
  }
}
