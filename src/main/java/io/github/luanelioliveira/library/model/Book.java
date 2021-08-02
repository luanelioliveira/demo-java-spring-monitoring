package io.github.luanelioliveira.library.model;

import lombok.Getter;

public class Book {

  @Getter private String isbn;

  @Getter private String title;

  @Getter private String description;

  public Book(String isbn, String title, String description) {
    this.isbn = isbn;
    this.title = title;
    this.description = description;
  }
}
