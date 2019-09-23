/*
 * Copyright of Philips, 2019
 *
 * This file is subject to the terms and conditions defined by Philips,
 * visit https://www.ip.philips.com/licensing/ for more details.
 *
 * @author: dsvellal@philips.com
 *
 */
package com.philips.anagram.steps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.philips.anagram.constants.PreProcessingSteps;
import com.philips.anagram.constants.ProgramBehaviorKeys;
import com.philips.anagram.constants.Punctuations;
import com.philips.anagram.constants.Whitespaces;

public class ProcessTest {
  private Process process;

  @Before
  public void setup() {
    process = new Process();
  }

  @Test
  public void testAllPreprocessingSteps() {
    final Map<ProgramBehaviorKeys, Object> configs = new HashMap<>();
    configs.put(ProgramBehaviorKeys.PreProcessingSteps, Arrays.asList(PreProcessingSteps.CaseNormalizer, PreProcessingSteps.PunctuationRemover, PreProcessingSteps.WhiteSpaceRemover));
    configs.put(ProgramBehaviorKeys.Punctuations, Arrays.asList(Punctuations.COLON));
    configs.put(ProgramBehaviorKeys.Whitespaces, Arrays.asList(Whitespaces.SPACE));

    final String firstString = "aB: ";
    final String secondString = "bA :";

    final List<String> output = process.execute(Arrays.asList(firstString, secondString), configs);
    Assert.assertEquals(Arrays.asList("ab", "ba"), output);
  }

  @Test
  (expected = IllegalArgumentException.class)
  public void testFailureOnGettingListOfProcessingSteps() {
    final Map<ProgramBehaviorKeys, Object> configs = new HashMap<>();
    configs.put(ProgramBehaviorKeys.PreProcessingSteps, PreProcessingSteps.CaseNormalizer);

    final String firstString = "aB: ";
    final String secondString = "bA :";

    process.execute(Arrays.asList(firstString, secondString), configs);
  }

}
