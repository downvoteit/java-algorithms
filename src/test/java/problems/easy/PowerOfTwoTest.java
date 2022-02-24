package problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class PowerOfTwoTest {
  @ParameterizedTest
  @CsvFileSource(resources = "/problems/PowerOfTwoTest.csv", numLinesToSkip = 1, delimiter = ';')
  public void positiveTest(int n, boolean expected) {
    boolean actual = new PowerOfTwo().isPowerOfTwo(n);

    Assertions.assertEquals(expected, actual);
  }
}
