/*
 * Copyright of Philips, 2019
 * 
 * This file is subject to the terms and conditions defined by Philips,
 * visit https://www.ip.philips.com/licensing/ for more details.
 *
 * @author: dsvellal@philips.com
 * 
 */
package com.philips.anagram.strategy;

import com.philips.anagram.utils.StringUtility;

public class DetectionBySortingStrategy implements Strategy {

  DetectionBySortingStrategy() {
  }

  @Override
  public boolean isAnagram(final String lhs, final String rhs) {
    boolean returnValue = false;

    final String sortedCharactersOfLHS = StringUtility.sortCharactersOfString(lhs);
    final String sortedCharactersOfRHS = StringUtility.sortCharactersOfString(rhs);
    returnValue = sortedCharactersOfLHS.equalsIgnoreCase(sortedCharactersOfRHS);

    return returnValue;
  }
}
