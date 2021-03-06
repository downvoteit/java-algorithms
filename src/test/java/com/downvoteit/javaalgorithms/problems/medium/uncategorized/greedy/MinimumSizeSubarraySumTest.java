package com.downvoteit.javaalgorithms.problems.medium.uncategorized.greedy;

import com.downvoteit.javaalgorithms.converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class MinimumSizeSubarraySumTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/MinimumSizeSubarraySumTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      int target, @ConvertWith(StringToIntArray.class) int[] nums, int expected) {
    int actual = new MinimumSizeSubarraySum().minSubArrayLen(target, nums);

    Assertions.assertEquals(expected, actual);
  }
}
