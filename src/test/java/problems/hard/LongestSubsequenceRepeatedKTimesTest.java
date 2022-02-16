package problems.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestSubsequenceRepeatedKTimesTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(
            "letsleetcode", 2, "let"), // letsleetcode = lets + leetcode = let[s] + le[e]t[code]
        arguments("bababcba", 2, "bba"), // bababcba = baba + bcba = b[a]ba + b[c]ba
        arguments("bb", 2, "b"), // bb = b + b
        arguments("ab", 2, "")); // ab = ""
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positive(String sequence, int num, String expected) {
    String actual =
        new LongestSubsequenceRepeatedKTimes().longestSubsequenceRepeatedK(sequence, num);

    Assertions.assertEquals(expected, actual);
  }
}
