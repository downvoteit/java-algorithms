package problems.easy;

import converters.StringToCharArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class FindSmallestLetterGreaterThanTargetTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/medium/FindSmallestLetterGreaterThanTargetTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToCharArray.class) char[] letters, char target, char expected) {
    char actual = new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters, target);

    System.out.println("target: " + target);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);

    Assertions.assertEquals(expected, actual);
  }
}
