package problems.medium.modifiedbinarysearch;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.Duration;

class FindPeakElementTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/FindPeakElementTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expectedArr) {
    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new FindPeakElement().findPeakElement(nums));

    boolean foundAny = false;
    for (int expected : expectedArr)
      if (expected == actual) {
        foundAny = true;
        break;
      }

    Assertions.assertTrue(foundAny);
  }
}
