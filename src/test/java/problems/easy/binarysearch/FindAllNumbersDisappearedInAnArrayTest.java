package problems.easy.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindAllNumbersDisappearedInAnArrayTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {4, 3, 2, 7, 8, 2, 3, 1}, new int[] {5, 6}),
        arguments(new int[] {1, 1}, new int[] {2}),
        arguments(new int[] {2, 2}, new int[] {1}),
        arguments(new int[] {1, 1, 2, 2}, new int[] {3, 4}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int[] expected) {
    List<Integer> actual = new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums);

    int expectedValue = Arrays.stream(expected).sum();
    int actualValue = actual.stream().mapToInt(o -> o).sum();

    Assertions.assertEquals(expectedValue, actualValue);
  }
}
