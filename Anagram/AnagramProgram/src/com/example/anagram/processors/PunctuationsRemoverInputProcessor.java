
package com.example.anagram.processors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.anagram.constants.ProgramBehaviorKeys;
import com.example.anagram.constants.Punctuations;
import com.example.anagram.utils.StringUtility;

public class PunctuationsRemoverInputProcessor implements InputProcessor {

  PunctuationsRemoverInputProcessor() {
  }

  @Override
  public List<String> process(final List<String> inputs, final Map<ProgramBehaviorKeys, Object> configs) {
    final List<Punctuations> punctuationsToRemove = (List<Punctuations>) configs.get(ProgramBehaviorKeys.Punctuations);
    final List<String> processedStringList = new ArrayList<>();

    for (String input : inputs) {
      for (final Punctuations punctuationToRemove : punctuationsToRemove) {
        input = StringUtility.removeFromString(input, punctuationToRemove.getValue());
      }

      processedStringList.add(input);
    }

    return processedStringList;
  }

}
