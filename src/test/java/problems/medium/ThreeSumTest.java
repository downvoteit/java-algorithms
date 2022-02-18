package problems.medium;

import converters.StringToIntArray;
import converters.StringToIntListInIntList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

class ThreeSumTest {
  @ParameterizedTest
  @CsvFileSource(resources = "/problems/medium/ThreeSum.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntListInIntList.class) List<List<Integer>> expected) {
    List<List<Integer>> actual = new ThreeSum().threeSum(nums);

    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }
}
