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
  public void positiveIterativeQuickSort(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    new IterativeQuickSort().sort(nums, 0, nums.length - 1);

    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(expected));

    Assertions.assertArrayEquals(expected, nums);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/implementations/SortTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveIterativeMergeSort(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    new IterativeMergeSort().sort(nums, nums.length);

    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(expected));

    Assertions.assertArrayEquals(expected, nums);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/implementations/SortTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveRecursiveMergeSort(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    new RecursiveMergeSort().sort(nums, 0, nums.length - 1);

    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(expected));

    Assertions.assertArrayEquals(expected, nums);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/implementations/SortTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveRecursiveQuickSort(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    new RecursiveQuickSort().sort(nums, 0, nums.length - 1);

    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(expected));

    Assertions.assertArrayEquals(expected, nums);
  }
}
