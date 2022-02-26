package implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringUtilityTest {
  static Stream<Arguments> source() {
    List<Integer> listOneOne = List.of(-1, -1, 2);
    List<Integer> listOneTwo = List.of(-1, 0, 1);

    return Stream.of(
        arguments("-1,-1,2#-1,0,1", List.of(listOneOne, listOneTwo)),
        arguments("-1,-1,2#", List.of(listOneOne)),
        arguments("#-1,0,1", List.of()),
        arguments("#", new ArrayList<>()));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void stringToIntListInIntListTest(String s, List<List<Integer>> expected) {
    List<List<Integer>> actual = StringUtility.stringToIntListInIntList(s);

    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }

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
    String actualValue = StringUtility.integerToNBitBinaryString(num, bitSize);
    boolean actual = actualValue.equals(expectedValue);

    System.out.println(expectedValue);
    System.out.println(actualValue);

    Assertions.assertEquals(actual, expected);
  }
}
