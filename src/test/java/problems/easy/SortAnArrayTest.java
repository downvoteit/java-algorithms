package problems.easy;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class SortAnArrayTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/easy/SortAnArrayTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    int[] actual = new SortAnArray().sortArray(nums);

    Assertions.assertArrayEquals(expected, actual);
  }
}
