package problems.easy.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BackspaceStringCompareTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments("ab#c", "ad#c", true),
        arguments("ab##", "c#d#", true),
        arguments("a#c", "b", false),
        arguments("a##c", "#a#c", true));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(String s, String t, boolean expected) {
    boolean actual = new BackspaceStringCompare().backspaceCompare(s, t);

    Assertions.assertEquals(expected, actual);
  }
}
