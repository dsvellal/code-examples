package com.example.anagram.constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PunctuationsTest {

  @Test
  public void testPunctuations() {
    assertNotNull(Punctuations.values());
    assertEquals(6, Punctuations.values().length);
    assertTrue(Punctuations.valueOf("COMMA") instanceof Punctuations);
    assertTrue(Punctuations.valueOf("SEMICOLON") instanceof Punctuations);
    assertTrue(Punctuations.valueOf("APOSTROPHE") instanceof Punctuations);
    assertTrue(Punctuations.valueOf("COLON") instanceof Punctuations);
    assertTrue(Punctuations.valueOf("EXCLAMATION") instanceof Punctuations);

    assertEquals(",", Punctuations.COMMA.getValue());
    assertEquals(";", Punctuations.SEMICOLON.getValue());
    assertEquals("'", Punctuations.APOSTROPHE.getValue());
    assertEquals(":", Punctuations.COLON.getValue());
    assertEquals("!", Punctuations.EXCLAMATION.getValue());
  }

}
