package problems.easy.bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class MissingNumberTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {3, 0, 1}, 2),
        arguments(new int[] {0, 1}, 2),
        arguments(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}, 8));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int expected) {
    int actual = new MissingNumber().missingNumber(nums);

    Assertions.assertEquals(expected, actual);
  }
}
