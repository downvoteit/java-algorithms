package com.downvoteit.javaalgorithms.problems.medium.twopointers;

import com.downvoteit.javaalgorithms.converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class TwoSumIIInputArrayIsSortedTest {
  @ParameterizedTest
  @CsvFileSource(resources = "/problems/TwoSumIITest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      int target,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    int[] actual = new TwoSumIIInputArrayIsSorted().twoSum(nums, target);

    Assertions.assertArrayEquals(expected, actual);
  }
}
