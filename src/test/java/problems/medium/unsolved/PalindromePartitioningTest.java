package problems.medium.unsolved;

import converters.StringToIntListInStringList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

class PalindromePartitioningTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/PalindromePartitioningTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      String s, @ConvertWith(StringToIntListInStringList.class) List<List<String>> expected) {
    List<List<String>> actual = new PalindromePartitioning().partition(s);

    Assertions.assertEquals(expected, actual);
  }
}
