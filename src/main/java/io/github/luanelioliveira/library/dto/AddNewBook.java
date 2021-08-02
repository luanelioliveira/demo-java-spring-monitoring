package io.github.luanelioliveira.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddNewBook {

  private String isbn;
  private String title;
  private String description;
}
