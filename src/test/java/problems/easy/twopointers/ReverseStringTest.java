package problems.easy.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseStringTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new char[] {'h', 'e', 'l', 'l', 'o'}, new char[] {'o', 'l', 'l', 'e', 'h'}),
        arguments(
            new char[] {'H', 'a', 'n', 'n', 'a', 'h'}, new char[] {'h', 'a', 'n', 'n', 'a', 'H'}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(char[] actual, char[] expected) {
    new ReverseString().reverseString(actual);

    Assertions.assertArrayEquals(expected, actual);
  }
}
