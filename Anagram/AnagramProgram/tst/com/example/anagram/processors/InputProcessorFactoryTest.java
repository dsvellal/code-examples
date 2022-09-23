package com.example.anagram.processors;

import org.junit.Assert;
import org.junit.Test;

import com.example.anagram.constants.PreProcessingSteps;

public class InputProcessorFactoryTest {

  @Test
  public void testFactoryToReturnCaseNormalizer() {
    final InputProcessor inputProcessor = InputProcessorFactory.getInputProcessorInstance(PreProcessingSteps.CaseNormalizer);
    Assert.assertNotNull(inputProcessor);
    Assert.assertTrue(inputProcessor instanceof CaseNormalizerInputProcessor);
  }

  @Test
  public void testFactoryToReturnWhitespaceRemover() {
    final InputProcessor inputProcessor = InputProcessorFactory.getInputProcessorInstance(PreProcessingSteps.WhiteSpaceRemover);
    Assert.assertNotNull(inputProcessor);
    Assert.assertTrue(inputProcessor instanceof WhiteSpaceRemoverInputProcessor);
  }

  @Test
  public void testFactoryToReturnPunctuationRemover() {
    final InputProcessor inputProcessor = InputProcessorFactory.getInputProcessorInstance(PreProcessingSteps.PunctuationRemover);
    Assert.assertNotNull(inputProcessor);
    Assert.assertTrue(inputProcessor instanceof PunctuationsRemoverInputProcessor);
  }
}
