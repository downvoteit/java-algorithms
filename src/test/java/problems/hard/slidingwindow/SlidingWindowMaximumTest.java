package problems.hard.slidingwindow;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

class SlidingWindowMaximumTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/SlidingWindowMaximumTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      int k,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    int[] actual = new SlidingWindowMaximum().maxSlidingWindow(nums, k);

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(actual));

    Assertions.assertArrayEquals(expected, actual);
  }
}
