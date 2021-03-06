package com.downvoteit.javaalgorithms.problems.easy.bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SingleNumberTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {2, 2, 1}, 1),
        arguments(new int[] {4, 1, 2, 1, 2}, 4),
        arguments(new int[] {1}, 1),
        arguments(new int[] {-1}, -1));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int expected) {
    int actual = new SingleNumber().singleNumber(nums);

    Assertions.assertEquals(expected, actual);
  }
}
