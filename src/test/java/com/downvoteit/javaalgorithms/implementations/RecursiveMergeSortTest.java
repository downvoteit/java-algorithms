package com.downvoteit.javaalgorithms.implementations;

import com.downvoteit.javaalgorithms.converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

class RecursiveMergeSortTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/implementations/CommonSortTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    new RecursiveMergeSort().sort(nums, 0, nums.length - 1);

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(nums));

    Assertions.assertArrayEquals(expected, nums);
  }
}
