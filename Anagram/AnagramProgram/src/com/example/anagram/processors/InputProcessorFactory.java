/*
 * Copyright of Philips, 2019
 *
 * This file is subject to the terms and conditions defined by Philips,
 * visit https://www.ip.philips.com/licensing/ for more details.
 *
 */
package com.philips.anagram.processors;

import com.philips.anagram.constants.PreProcessingSteps;

public class InputProcessorFactory {

  private InputProcessorFactory() {
  }

  public static InputProcessor getInputProcessorInstance(final PreProcessingSteps inputProcessor) {
    InputProcessor inputProcessorInstance = null;
    switch (inputProcessor) {
    case CaseNormalizer:
      inputProcessorInstance = new CaseNormalizerInputProcessor();
      break;

    case WhiteSpaceRemover:
      inputProcessorInstance = new WhiteSpaceRemoverInputProcessor();
      break;

    case PunctuationRemover:
      inputProcessorInstance = new PunctuationsRemoverInputProcessor();
      break;
    }

    return inputProcessorInstance;
  }

}
