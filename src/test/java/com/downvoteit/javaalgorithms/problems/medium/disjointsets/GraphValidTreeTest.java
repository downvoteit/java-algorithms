package com.downvoteit.javaalgorithms.problems.medium.disjointsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class GraphValidTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}, true),
        arguments(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}, false), // acyclic
        arguments(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}, false), // second less than 3 vertices
        arguments(4, new int[][] {{0, 1}, {2, 3}}, false), // both less than 3 vertices
        arguments(1, new int[][] {}, true),
        arguments(2, new int[][] {{1, 0}}, true),
        arguments(2, new int[][] {}, false));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int n, int[][] edges, boolean expected) {
    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new GraphValidTree().validTree(n, edges));

    Assertions.assertEquals(expected, actual);
  }
}
