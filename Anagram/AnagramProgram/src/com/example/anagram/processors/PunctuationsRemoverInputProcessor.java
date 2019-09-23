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
import com.philips.anagram.constants.Punctuations;
import com.philips.anagram.utils.StringUtility;

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
