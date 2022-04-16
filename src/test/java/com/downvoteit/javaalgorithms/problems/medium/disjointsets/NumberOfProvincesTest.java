package com.downvoteit.javaalgorithms.problems.medium.disjointsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfProvincesTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, 2),
        arguments(new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, 3),
        arguments(new int[][] {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}, 1));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[][] isConnected, int expected) {
    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new NumberOfProvinces().findCircleNum(isConnected));

    Assertions.assertEquals(expected, actual);
  }
}
