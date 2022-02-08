package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class FibonacciNumbersTest {
  static Stream<Arguments> source() {
    return Stream.of(arguments(0, 0), arguments(1, 1), arguments(4, 3), arguments(7, 13));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positive(int nums, int expected) {
    int actual = new FibonacciNumbers().calculate(nums);

    Assertions.assertEquals(expected, actual);
  }
}
