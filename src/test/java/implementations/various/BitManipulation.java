package implementations.various;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BitManipulation {
  public static void main(String[] args) {}

  @ParameterizedTest
  @CsvSource({"1,-1,true", "101,-101,true", "102,102,false"})
  public void isNegativeNumberTest(int x, int y, boolean expected) {
    boolean actual = (~x + 1) == y;

    Assertions.assertEquals(actual, expected);
  }

  // TODO swap numbers
  // TODO find odd occurring
  // TODO single number

  @ParameterizedTest
  @CsvSource({"100,-1,true", "100,501,false"})
  public void isOppositeSignTest(int x, int y, boolean expected) {
    boolean actual = (x ^ y) < 0;

    Assertions.assertEquals(actual, expected);
  }

  @ParameterizedTest
  @CsvSource({"1,8,2,true", "12,15,2,true", "0,0,1,false"})
  public void hasDifferentBitPositionTest(int x, int y, int z, boolean expected) {
    int xor = x ^ y, distance = 0;

    while (xor != 0) {
      distance++;
      xor &= xor - 1;
    }

    boolean actual = distance == z;

    Assertions.assertEquals(actual, expected);
  }
}
