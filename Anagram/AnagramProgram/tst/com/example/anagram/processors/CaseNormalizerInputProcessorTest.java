package com.example.anagram.processors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.anagram.constants.ProgramBehaviorKeys;

public class CaseNormalizerInputProcessorTest {

  private CaseNormalizerInputProcessor processor;
  private List<String> inputs;
  private Map<ProgramBehaviorKeys, Object> behaviorMap;

  @Before
  public void setUp() {
    processor = new CaseNormalizerInputProcessor();
    behaviorMap = new HashMap<>();
  }

  @Test
  public void testCaseNormalizerInputProcessor() {
    final String firstString = "AB!";
    final String secondString = "Ab1";
    inputs = Arrays.asList(firstString, secondString);
    final List<String> outputs = processor.process(inputs, behaviorMap);
    Assert.assertEquals(2, outputs.size());
    Assert.assertEquals(firstString.toLowerCase(), outputs.get(0));
    Assert.assertEquals(secondString.toLowerCase(), outputs.get(1));
  }

}
