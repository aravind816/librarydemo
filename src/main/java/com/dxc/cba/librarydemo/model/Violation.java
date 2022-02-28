package com.dxc.cba.librarydemo.model;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Violation {
    
  private final String fieldName;

  private final String message;

  public Violation(String fieldName, String message) {
    this.fieldName = fieldName;
    this.message = message;
  }

}
