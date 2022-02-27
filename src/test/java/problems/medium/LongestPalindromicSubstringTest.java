package problems.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class LongestPalindromicSubstringTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/LongestPalindromicSubstringTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(String s, String expected) {
    String actual = new LongestPalindromicSubstring().longestPalindrome(s);

    Assertions.assertEquals(expected, actual);
  }
}
