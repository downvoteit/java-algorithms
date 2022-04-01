package problems.easy.uncategorized.hashtable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class ContainsDuplicatesTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {3, 3}, true),
        arguments(new int[] {1, 2, 3, 1}, true),
        arguments(new int[] {1, 2, 3, 4}, false),
        arguments(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, boolean expected) {
    boolean actual = new ContainsDuplicates().containsDuplicate(nums);

    Assertions.assertEquals(expected, actual);
  }
}
