package com.downvoteit.javaalgorithms.problems.medium.unsolved;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class PalindromicSubstringsTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/PalindromicSubstringsTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(String s, int expected) {
    int actual = new PalindromicSubstrings().countSubstrings(s);

    Assertions.assertEquals(expected, actual);
  }
}
