package com.example.anagram.constants;

public enum Punctuations {
  COMMA(","), SEMICOLON(";"), APOSTROPHE("'"), COLON(":"), EXCLAMATION("!");

  private String punctuation;

  Punctuations(final String punctuation) {
    this.punctuation = punctuation;
  }

  public String getValue() {
    return this.punctuation;
  }
}
