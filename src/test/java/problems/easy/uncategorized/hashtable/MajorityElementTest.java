package problems.easy.uncategorized.hashtable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class MajorityElementTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {3, 2, 3}, 3),
        arguments(new int[] {2, 2, 1, 1, 1, 2, 2}, 2),
        arguments(new int[] {1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 5, 5}, 3),
        arguments(new int[] {1}, 1));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int expected) {
    int actual = new MajorityElement().majorityElement(nums);

    Assertions.assertEquals(expected, actual);
  }
}
