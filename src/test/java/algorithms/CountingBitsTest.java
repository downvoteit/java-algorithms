package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountingBitsTest {
  static Stream<Arguments> source() {
    return Stream.of(arguments(2, new int[] {0, 1, 1}), arguments(5, new int[] {0, 1, 1, 2, 1, 2}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positive(int n, int[] expected) {
    int[] actual = new CountingBits().countBits(n);

    int expectedValue = Arrays.stream(expected).sum();
    int actualValue = Arrays.stream(actual).sum();

    Assertions.assertEquals(actualValue, expectedValue);
  }
}
