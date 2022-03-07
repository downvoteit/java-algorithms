package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindIfPathExistsInGraphTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, 0, 2, true),
        arguments(6, new int[][] {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5, false));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int n, int[][] edges, int source, int destination, boolean expected) {
    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50),
            () -> new FindIfPathExistsInGraph().validPath(n, edges, source, destination));

    Assertions.assertEquals(expected, actual);
  }
}
