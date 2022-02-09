package algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestConsecutiveSequenceTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {100, 4, 200, 1, 3, 2}, 4),
        arguments(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positive(int[] nums, int expected) {
    int actual = new LongestConsecutiveSequence().longestConsecutive(nums);

    Assertions.assertEquals(expected, actual);
  }
}
