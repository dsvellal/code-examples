/*
 * Copyright of Philips, 2019
 *
 * This file is subject to the terms and conditions defined by Philips,
 * visit https://www.ip.philips.com/licensing/ for more details.
 *
 */
package com.philips.anagram.processors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.philips.anagram.constants.ProgramBehaviorKeys;
import com.philips.anagram.constants.Whitespaces;

public class WhiteSpaceRemoverInputProcessorTest {
  private WhiteSpaceRemoverInputProcessor processor;
  private Map<ProgramBehaviorKeys, Object> configs;
  private List<String> inputs;

  @Before
  public void setup() {
    configs = new HashMap<>();
    configs.put(ProgramBehaviorKeys.Whitespaces, Arrays.asList(Whitespaces.LINE,
        Whitespaces.TAB,
        Whitespaces.SPACE));
    processor = new WhiteSpaceRemoverInputProcessor();
  }

  @Test
  public void testWhiteSpaceRemoverInputProcessor() {
    final String firstString = "\nAbc\t";
    final String secondString = " Abc21!#";
    inputs = Arrays.asList(firstString, secondString);
    final List<String> output = processor.process(inputs, configs);
    Assert.assertEquals(2, output.size());
    Assert.assertEquals(firstString.replaceAll("\\n", "").replaceAll("\\t", ""), output.get(0));
    Assert.assertEquals(secondString.replaceAll(" ", ""), output.get(1));
  }
}
