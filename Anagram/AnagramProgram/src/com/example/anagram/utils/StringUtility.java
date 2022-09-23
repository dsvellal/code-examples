package com.example.anagram.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtility {
  private static final String EMPTY_STR = "";

  private StringUtility() {

  }

  public static String sortCharactersOfString(final String string) {
    final char[] charactersOfString = string.toCharArray();
    Arrays.sort(charactersOfString);
    final String sortedString = String.valueOf(charactersOfString);
    return sortedString;
  }

  public static String removeFromString(final String string, final String toRemove) {
    final String trimmedString = string.replaceAll(toRemove, EMPTY_STR);
    return trimmedString;
  }

  public static List<String> getTokens(final String completeString, final String delimiter) {
    final List<String> tokens = new ArrayList<>();
    final StringTokenizer strTok = new StringTokenizer(completeString, delimiter);
    while (strTok.hasMoreTokens()) {
      tokens.add(strTok.nextToken());
    }

    return tokens;
  }

}
