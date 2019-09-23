package com.philips.anagram.constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class ConstantsToDataTypeMappingTest {

  @Test
  public void testConstantsToDataTypeMappingHappyCase() {
    final Map<ProgramBehaviorKeys, Class<?>> map = ConstantsToDataTypeMapping.getMapInstance();
    assertNotNull(map);

    for (final Entry<ProgramBehaviorKeys, Class<?>> entry : map.entrySet()) {
      assertNotNull(entry.getKey());
      assertNotNull(entry.getValue());
      assertTrue(entry.getKey() instanceof ProgramBehaviorKeys);
    }

    assertEquals(String.class, map.get(ProgramBehaviorKeys.DetectionAlgorithm));
    assertEquals(Collections.<String>emptyList().getClass(), map.get(ProgramBehaviorKeys.PreProcessingSteps));
    assertEquals(Collections.<String>emptyList().getClass(), map.get(ProgramBehaviorKeys.Punctuations));
    assertEquals(Collections.<String>emptyList().getClass(), map.get(ProgramBehaviorKeys.StepsToExecute));
    assertEquals(Collections.<String>emptyList().getClass(), map.get(ProgramBehaviorKeys.ValidationSteps));
    assertEquals(Collections.<String>emptyList().getClass(), map.get(ProgramBehaviorKeys.Whitespaces));
  }
}
