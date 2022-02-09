package algorithms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class ClimbingStairsTest {
  static Stream<Arguments> source() {
    return Stream.of(arguments(2, 2), arguments(3, 3));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positive(int n, int expected) {
    int actual = new ClimbingStairs().climbStairs(n);

    Assertions.assertEquals(expected, actual);
  }
}
