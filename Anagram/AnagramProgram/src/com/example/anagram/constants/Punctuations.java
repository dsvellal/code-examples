/*
 * Copyright of Philips, 2019
 * 
 * This file is subject to the terms and conditions defined by Philips,
 * visit https://www.ip.philips.com/licensing/ for more details.
 *
 */
package com.philips.anagram.constants;

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
