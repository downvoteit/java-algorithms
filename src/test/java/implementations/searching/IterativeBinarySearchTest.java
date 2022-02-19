package implementations.searching;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class IterativeBinarySearchTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/implementations/CommonSearchTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums, int target, int expected) {
    int actual = new IterativeBinarySearch().search(nums, target);

    Assertions.assertEquals(expected, actual);
  }
}
