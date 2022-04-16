package com.downvoteit.javaalgorithms.problems.medium.disjointsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfConnectedComponentsInAnUndirectedGraphTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}, 2),
        arguments(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}, 1),
        arguments(6, new int[][] {{0, 1}, {0, 2}, {2, 5}, {3, 4}, {3, 5}}, 1));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int n, int[][] edges, int expected) {
    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50),
            () -> new NumberOfConnectedComponentsInAnUndirectedGraph().countComponents(n, edges));

    Assertions.assertEquals(expected, actual);
  }
}
