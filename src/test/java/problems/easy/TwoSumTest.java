package problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoSumTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {0, 4, 3, 0}, 0, new int[] {0, 3}),
        arguments(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
        arguments(new int[] {3, 2, 4}, 6, new int[] {1, 2}),
        arguments(new int[] {3, 3}, 6, new int[] {0, 1}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int target, int[] expected) {
    int[] actual = new TwoSum().twoSum(nums, target);

    int expectedValue = Arrays.stream(expected).sum();
    int actualValue = Arrays.stream(actual).sum();

    Assertions.assertEquals(expectedValue, actualValue);
  }
}
