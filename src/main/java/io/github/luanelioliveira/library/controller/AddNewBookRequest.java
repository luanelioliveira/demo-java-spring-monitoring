package io.github.luanelioliveira.library.controller;

import io.github.luanelioliveira.library.dto.AddNewBook;
import lombok.Data;

@Data
public class AddNewBookRequest {

  private String isbn;
  private String title;
  private String description;

  public AddNewBook toCommand() {
    return new AddNewBook(isbn, title, description);
  }
}
