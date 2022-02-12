package algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class HouseRobberTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {1, 2, 3, 1}, 4),
        arguments(new int[] {2, 7, 9, 3, 1}, 12),
        arguments(new int[] {}, 0),
        arguments(new int[] {0, 0, 0, 0, 0, 0}, 0),
        arguments(new int[] {0, 1, 0, 1, 0, 0}, 2),
        arguments(new int[] {1, 0, 0, 1, 2, 0}, 3),
        arguments(new int[] {1, 2}, 2),
        arguments(new int[] {1, 3, 1}, 3));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positive(int[] nums, int expected) {
    int actual = new HouseRobber().rob(nums);

    Assertions.assertEquals(expected, actual);
  }
}
