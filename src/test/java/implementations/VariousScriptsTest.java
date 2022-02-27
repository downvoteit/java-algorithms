package implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class VariousScriptsTest {
  @ParameterizedTest
  @CsvSource({
    "1,32,00000000 00000000 00000000 00000001,true",
    "15,32,00000000 00000000 00000000 00001111,true",
    "0,32,00000000 00000000 00000000 00000001,false",
    "1,0,00000001,true",
    "2,8,00000010,true",
    "4,8,00000100,true",
    "0,8,00000001,false",
  })
  public void stringToIntListInIntListTest(
      int num, int bitSize, String expectedValue, boolean expected) {
    String actualValue = VariousScripts.integerToNBitBinaryString(num, bitSize);
    boolean actual = actualValue.equals(expectedValue);

    System.out.println(expectedValue);
    System.out.println(actualValue);

    Assertions.assertEquals(actual, expected);
  }
}
