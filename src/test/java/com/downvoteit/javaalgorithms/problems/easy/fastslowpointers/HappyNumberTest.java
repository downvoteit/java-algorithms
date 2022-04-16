package com.downvoteit.javaalgorithms.problems.easy.fastslowpointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class HappyNumberTest {
  @ParameterizedTest
  @CsvFileSource(resources = "/problems/HappyNumberTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveTest(int n, boolean expected) {
    boolean actual = new HappyNumber().isHappy(n);

    Assertions.assertEquals(expected, actual);
  }
}
