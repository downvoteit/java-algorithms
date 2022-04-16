package com.downvoteit.javaalgorithms.problems.medium.heaps;

import com.downvoteit.javaalgorithms.converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.Duration;
import java.util.Arrays;

class TopKFrequentElementsTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/TopKFrequentElementsTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      int k,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    int[] actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new TopKFrequentElements().topKFrequent(nums, k));

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(actual));

    Assertions.assertArrayEquals(expected, actual);
  }
}
