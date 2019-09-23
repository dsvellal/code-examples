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
import com.philips.anagram.constants.Punctuations;

public class PunctuationRemoverInputProcessorTest {

  private List<String> inputs;
  private Map<ProgramBehaviorKeys, Object> configs;
  private PunctuationsRemoverInputProcessor processor;

  @Before
  public void setUp() {
    processor  = new PunctuationsRemoverInputProcessor();
    configs = new HashMap<>();
    configs.put(ProgramBehaviorKeys.Punctuations, Arrays.asList(Punctuations.APOSTROPHE,
                                                                Punctuations.COLON,
                                                                Punctuations.EXCLAMATION,
                                                                Punctuations.SEMICOLON,
                                                                Punctuations.COMMA));
  }

  @Test
  public void testPunctuationRemoverInputProcessor() {
    final String firstString = ";!:abc";
    final String secondString = "Abc123#";
    inputs = Arrays.asList(firstString, secondString);
    final List<String> outputs = processor.process(inputs, configs);
    Assert.assertEquals(2, outputs.size());
    Assert.assertEquals(firstString.replaceAll(";", "")
        .replaceAll("!", "")
        .replaceAll(":", ""), outputs.get(0));
    Assert.assertEquals(secondString, outputs.get(1));
  }
}
