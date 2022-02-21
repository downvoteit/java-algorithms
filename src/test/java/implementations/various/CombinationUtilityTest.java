package implementations.various;

import converters.StringToIntListInIntList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class CombinationUtilityTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(5, 3, new long[] {60, 10}),
        arguments(14, 3, new long[] {2184, 364}),
        arguments(1, 1, new long[] {1, 1}),
        arguments(2, 1, new long[] {2, 2}));
  }

  @ParameterizedTest
  @MethodSource("source")
  void calculateCombinationsAndPermutationsTest(int n, int r, long[] expected) {
    long[] actual = new CombinationUtility().calculateCombinationsAndPermutations(n, r);

    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  void calculateCombinationsAndPermutationsNGreaterThanRTest() {
    Exception exception =
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new CombinationUtility().calculateCombinationsAndPermutations(3, 4));

    String expectedMsg = "r cannot be greater than n";
    String actualMsg = exception.getMessage();

    Assertions.assertTrue(actualMsg.contains(expectedMsg));
  }

  @ParameterizedTest
  @CsvFileSource(
      resources = "/implementations/CombinationUtilityTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  void generateAllPossibleCombinationsTest(
      int n, int r, @ConvertWith(StringToIntListInIntList.class) List<List<Integer>> expected) {
    long[] info = new CombinationUtility().calculateCombinationsAndPermutations(n, r);

    Assertions.assertNotNull(info);

    int combinations = (int) info[1];

    List<List<Integer>> actual = new CombinationUtility().generateAllPossibleCombinations(n, r);

    int[] expectedArr = IntListInIntListTo1DArray(r, expected, combinations);
    int[] actualArr = IntListInIntListTo1DArray(r, actual, combinations);

    Assertions.assertArrayEquals(expectedArr, actualArr);
  }

  private int[] IntListInIntListTo1DArray(int r, List<List<Integer>> outer, int combinations) {
    int count = 0;
    int[] expectedArr = new int[combinations * r];
    for (List<Integer> inner : outer)
      for (Integer value : inner) {
        expectedArr[count++] = value;
      }

    return expectedArr;
  }
}
