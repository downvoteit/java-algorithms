package problems.easy.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class PascalsTriangleTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(5, new Integer[][] {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}}),
        arguments(1, new Integer[][] {{1}}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int numRows, Integer[][] expected) {
    List<List<Integer>> actualValue =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new PascalsTriangle().generate(numRows));

    Integer[][] actual = new Integer[actualValue.size()][];

    for (int i = 0; i < actualValue.size(); i++)
      actual[i] = actualValue.get(i).toArray(new Integer[] {});

    System.out.println(Arrays.deepToString(expected));
    System.out.println(Arrays.deepToString(actual));

    Assertions.assertArrayEquals(expected, actual);
  }
}
