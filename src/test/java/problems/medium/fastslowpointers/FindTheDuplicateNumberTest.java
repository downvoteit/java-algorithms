package problems.medium.fastslowpointers;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class FindTheDuplicateNumberTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/FindTheDuplicateNumberTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTestThree(@ConvertWith(StringToIntArray.class) int[] nums, int expected) {
    int actual = new FindTheDuplicateNumber().findDuplicate(nums);

    Assertions.assertEquals(expected, actual);
  }
}
