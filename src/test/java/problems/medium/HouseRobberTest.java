package problems.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import converters.StringToIntArray;

class HouseRobberTest {
  @ParameterizedTest
  @CsvFileSource(resources = "/HouseRobberTest.tsv", numLinesToSkip = 1, delimiter = ';')
  public void positive(@ConvertWith(StringToIntArray.class) int[] nums, int expected) {
    int actual = new HouseRobber().rob(nums);

    Assertions.assertEquals(expected, actual);
  }
}
