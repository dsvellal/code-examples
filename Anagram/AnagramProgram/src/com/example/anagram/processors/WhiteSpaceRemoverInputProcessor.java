package com.example.anagram.processors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.anagram.constants.ProgramBehaviorKeys;
import com.example.anagram.constants.Whitespaces;
import com.example.anagram.utils.StringUtility;

public class WhiteSpaceRemoverInputProcessor implements InputProcessor {

  WhiteSpaceRemoverInputProcessor() {
  }

  @Override
  public List<String> process(final List<String> inputs, final Map<ProgramBehaviorKeys, Object> configs) {
    final List<Whitespaces> whiteSpacesToRemove = (List<Whitespaces>) configs.get(ProgramBehaviorKeys.Whitespaces);
    final List<String> processedStringList = new ArrayList<>();

    for (String input : inputs) {
      for (final Whitespaces whiteSpaceToRemove : whiteSpacesToRemove) {
        input = StringUtility.removeFromString(input, whiteSpaceToRemove.getValue());
      }

      processedStringList.add(input);
    }

    return processedStringList;
  }
}
