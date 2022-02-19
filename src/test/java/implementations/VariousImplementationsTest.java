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

class VariousImplementationsTest {
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
    List<List<Integer>> actual = new VariousImplementations().stringToIntListInIntList(s);

    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }

  // ----------------- Bit manipulation ----------------- //

  @ParameterizedTest
  @CsvSource({"1,-1,true", "101,-101,true", "102,102,false"})
  public void isNegativeTest(int x, int y, boolean expected) {
    boolean actual = (~x + 1) == y;

    Assertions.assertEquals(actual, expected);
  }

  // swap numbers
  // find odd occurring

  @ParameterizedTest
  @CsvSource({"100,-1,true", "100,501,false"})
  public void isOppositeSignTest(int x, int y, boolean expected) {
    boolean actual = (x ^ y) < 0;

    Assertions.assertEquals(actual, expected);
  }
}
