package implementations;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

public class SortTest {
  @ParameterizedTest
  @CsvFileSource(resources = "/implementations/SortTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveIterativeQuickSortTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    new IterativeQuickSort().sort(nums, 0, nums.length - 1);

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(nums));

    Assertions.assertArrayEquals(expected, nums);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/implementations/SortTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveIterativeMergeSortTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    new IterativeMergeSort().sort(nums, nums.length);

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(nums));

    Assertions.assertArrayEquals(expected, nums);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/implementations/SortTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveRecursiveMergeSortTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    new RecursiveMergeSort().sort(nums, 0, nums.length - 1);

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(nums));

    Assertions.assertArrayEquals(expected, nums);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/implementations/SortTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveRecursiveQuickSortTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    new RecursiveQuickSort().sort(nums, 0, nums.length - 1);

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(nums));

    Assertions.assertArrayEquals(expected, nums);
  }
}
