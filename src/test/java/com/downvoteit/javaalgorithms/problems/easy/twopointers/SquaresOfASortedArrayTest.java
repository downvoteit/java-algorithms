package com.downvoteit.javaalgorithms.problems.easy.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SquaresOfASortedArrayTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {-4, -1, 0, 3, 10}, new int[] {0, 1, 9, 16, 100}),
        arguments(new int[] {-7, -3, 2, 3, 11}, new int[] {4, 9, 9, 49, 121}),
        arguments(new int[] {-5, -3, -2, -1}, new int[] {1, 4, 9, 25}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int[] expected) {
    int[] actual = new SquaresOfASortedArray().sortedSquares(nums);

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(actual));

    Assertions.assertArrayEquals(expected, actual);
  }
}
