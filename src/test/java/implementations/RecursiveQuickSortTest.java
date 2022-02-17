package implementations;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

class RecursiveQuickSortTest {
  @ParameterizedTest
  @CsvFileSource(resources = "/implementations/SortTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positive(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    new RecursiveQuickSort().sort(nums, 0, nums.length - 1);

    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(expected));

    Assertions.assertArrayEquals(expected, nums);
  }
}
