package com.downvoteit.javaalgorithms.problems.medium.design;

import com.downvoteit.javaalgorithms.converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

class SortAnArrayTest {
  @ParameterizedTest
  @CsvFileSource(resources = "/problems/SortAnArrayTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    int[] actual = new SortAnArray().sortArray(nums);

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(nums));

    Assertions.assertArrayEquals(expected, actual);
  }
}
