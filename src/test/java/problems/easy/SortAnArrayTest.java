package problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import problems.easy.unsolved.SortAnArray;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortAnArrayTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {5, 2, 3, 1}, new int[] {1, 2, 3, 5}),
        arguments(new int[] {5, 1, 1, 2, 0, 0}, new int[] {0, 0, 1, 1, 2, 5}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int[] expected) {
    int[] actual = new SortAnArray().sortArray(nums);

    int expectedValue = Arrays.stream(expected).sum();
    int actualValue = Arrays.stream(actual).sum();

    Assertions.assertEquals(expectedValue, actualValue);
  }
}
