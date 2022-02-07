package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindAllNumberDisappearingTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {4, 3, 2, 7, 8, 2, 3, 1}, new int[] {5, 6}),
        arguments(new int[] {1, 1}, new int[] {2}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positive(int[] nums, int[] expected) {
    List<Integer> got = new FindAllNumberDisappearing().findDisappearedNumbers(nums);

    int[] array = got.stream().mapToInt(o -> o).toArray();

    Assertions.assertArrayEquals(expected, array);
  }
}
