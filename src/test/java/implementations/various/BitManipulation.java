package implementations.various;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BitManipulation {
  @ParameterizedTest
  @CsvSource({"1,-1,true", "101,-101,true", "102,102,false"})
  public void isNegativeTest(int x, int y, boolean expected) {
    boolean actual = (~x + 1) == y;

    Assertions.assertEquals(actual, expected);
  }

  // TODO swap numbers
  // TODO find odd occurring

  @ParameterizedTest
  @CsvSource({"100,-1,true", "100,501,false"})
  public void isOppositeSignTest(int x, int y, boolean expected) {
    boolean actual = (x ^ y) < 0;

    Assertions.assertEquals(actual, expected);
  }
}
