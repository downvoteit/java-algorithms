package com.downvoteit.javaalgorithms.problems.medium.dynamicprogramming;

import com.downvoteit.javaalgorithms.converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class HouseRobberTest {
  @ParameterizedTest
  @CsvFileSource(resources = "/problems/HouseRobberTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveTest(@ConvertWith(StringToIntArray.class) int[] nums, int expected) {
    int actual = new HouseRobber().rob(nums);

    Assertions.assertEquals(expected, actual);
  }
}
