package com.downvoteit.javaalgorithms.problems.easy.modifiedbinarysearch;

import com.downvoteit.javaalgorithms.converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.Duration;

class PeakIndexInAMountainArrayTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/PeakIndexInAMountainArrayTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(@ConvertWith(StringToIntArray.class) int[] arr, int expected) {
    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50),
            () -> new PeakIndexInAMountainArray().peakIndexInMountainArray(arr));

    Assertions.assertEquals(expected, actual);
  }
}
