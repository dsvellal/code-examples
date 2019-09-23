/*
 * Copyright of Philips, 2019
 *
 * This file is subject to the terms and conditions defined by Philips,
 * visit https://www.ip.philips.com/licensing/ for more details.
 *
 */
package com.philips.anagram.processors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.philips.anagram.constants.ProgramBehaviorKeys;
import com.philips.anagram.constants.Whitespaces;
import com.philips.anagram.utils.StringUtility;

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
