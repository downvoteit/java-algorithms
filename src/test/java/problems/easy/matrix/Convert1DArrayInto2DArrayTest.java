package problems.easy.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Convert1DArrayInto2DArrayTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {1, 2, 3, 4}, 2, 2, new int[][] {{1, 2}, {3, 4}}),
        arguments(new int[] {1, 2, 3}, 1, 3, new int[][] {{1, 2, 3}}),
        arguments(new int[] {1, 2}, 1, 1, new int[][] {}),
        arguments(new int[] {3}, 1, 2, new int[][] {}),
        arguments(new int[] {2}, 1, 1, new int[][] {{2}}),
        arguments(new int[] {5}, 3, 1, new int[][] {}),
        arguments(new int[] {1, 1, 1, 1}, 4, 1, new int[][] {{1}, {1}, {1}, {1}}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int m, int n, int[][] expected) {
    int[][] actual = new Convert1DArrayInto2DArray().construct2DArray(nums, m, n);

    Assertions.assertArrayEquals(expected, actual);
  }
}
