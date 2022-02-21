package implementations.various;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// TODO 1. count number of digits in an integer (division by 10)
// TODO 2. convert decimal number to binary (bitwise left-shift)
// TODO 3. count set bits (and)
// DONE 4. check if number is even/odd (and)
// TODO 5. check if number is of power of 2 or not (and)
// DONE 6. find number of flips required to make a|b equal to c (not)
// DONE 7. switch number's sign (not)
// TODO 8. swap numbers (xor)
// TODO 9. find odd occurring (xor)
// DONE 10. detect if two integers have opposite signs (xor)
// TODO 11. hamming distance (xor)
// TODO 12. single number (xor)
// TODO 13. missing number (xor)
// TODO 14. find bit length of number (bitwise left-shift)
// TODO 15. check if kth bit is set/unset (bitwise left/right-shift)
// TODO 16. subset/powerset (bitwise left-shift)
// TODO 17. get first set bit position (bitwise left-shift)
public class BitManipulation {
  public static void main(String[] args) {}

  @ParameterizedTest
  @CsvSource({"1,-1,true", "101,-101,true", "102,102,false"})
  public void isNegativeNumberTest(int x, int y, boolean expected) {
    boolean actual = (~x + 1) == y;

    Assertions.assertEquals(actual, expected);
  }

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

  @ParameterizedTest
  @CsvSource({"2,1,4,true", "3,2,12,true", "1,2,5,false"})
  public void isLeftShiftedTest(int x, int y, int z, boolean expected) {
    boolean actual = (x << y) == z;

    Assertions.assertEquals(actual, expected);
  }
}
