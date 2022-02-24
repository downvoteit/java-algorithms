package problems.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class LongestSubsequenceRepeatedKTimesTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/LongestSubsequenceRepeatedKTimesTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(String sequence, int num, String expected) {
    String actual =
        new LongestSubsequenceRepeatedKTimes().longestSubsequenceRepeatedK(sequence, num);

    Assertions.assertEquals(expected, actual);
  }
}
