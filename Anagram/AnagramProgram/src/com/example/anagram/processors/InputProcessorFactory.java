package com.example.anagram.processors;

import com.example.anagram.constants.PreProcessingSteps;

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
