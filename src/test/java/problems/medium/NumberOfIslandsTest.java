package problems.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfIslandsTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(
            new char[][] {
              {'1', '1', '1', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '0', '0', '0'}
            },
            1),
        arguments(
            new char[][] {
              {'1', '1', '0', '0', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '1', '0', '0'},
              {'0', '0', '0', '1', '1'}
            },
            3));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(char[][] grid, int expected) {
    int actual = new NumberOfIslands().numIslands(grid);

    Assertions.assertEquals(expected, actual);
  }
}
