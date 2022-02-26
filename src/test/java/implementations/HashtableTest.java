package implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class HashtableTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {10, 15, 20, 17, 25}, "abc_17", "17", "[abc_20:20, abc_17:17]"),
        arguments(new int[] {10, 15, 20, 17, 25}, "abc_10", "10", "[abc_10:10]"),
        arguments(new int[] {10, 15, 20, 17, 25}, "abc_25", "25", "[abc_25:25]"));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, String forKey, Integer expectedValue, String expectedTwo) {
    Hashtable<String, Integer> hashtable = new Hashtable<>();

    for (int i : nums) {
      hashtable.put("abc_" + i, i);
    }

    Assertions.assertEquals(expectedValue, hashtable.get(forKey));

    System.out.println(hashtable);

    Assertions.assertTrue(hashtable.toString().contains(expectedTwo));
  }
}
