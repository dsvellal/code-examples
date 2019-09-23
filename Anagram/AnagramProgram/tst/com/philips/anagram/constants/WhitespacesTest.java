package com.philips.anagram.constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WhitespacesTest {

  // SPACE(" "), TAB("\\t"), LINE("\\n");

  @Test
  public void testWhitespaces() {
    assertNotNull(Whitespaces.values());
    assertEquals(3, Whitespaces.values().length);
    assertTrue(Whitespaces.valueOf("SPACE") instanceof Whitespaces);
    assertTrue(Whitespaces.valueOf("TAB") instanceof Whitespaces);
    assertTrue(Whitespaces.valueOf("LINE") instanceof Whitespaces);

    assertEquals(" ", Whitespaces.SPACE.getValue());
    assertEquals("\\t", Whitespaces.TAB.getValue());
    assertEquals("\\n", Whitespaces.LINE.getValue());
  }

}
