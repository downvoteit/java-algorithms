package problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumSubarrayTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
        arguments(new int[] {1}, 1),
        arguments(new int[] {5, 4, -1, 7, 8}, 23));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int expected) {
    int actual = new MaximumSubarray().maxSubArray(nums);

    Assertions.assertEquals(expected, actual);
  }
}
