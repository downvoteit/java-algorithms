package implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LinkedListHashtableTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {10, 15, 20, 17, 25}, "abc_17", "17"),
        arguments(new int[] {10, 15, 20, 17, 25}, "abc_10", "10"),
        arguments(new int[] {10, 15, 20, 17, 25}, "abc_25", "25"));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, String forKey, Integer expected) {
    LinkedListHashtable<String, Integer> hashtable = new LinkedListHashtable<>();

    for (int i : nums) {
      hashtable.put("abc_" + i, i);
    }

    System.out.println(hashtable);

    Assertions.assertEquals(nums.length, hashtable.getSize());
    Assertions.assertEquals(expected, hashtable.get(forKey));

    hashtable.remove(forKey);

    Assertions.assertNull(hashtable.get(forKey));
  }
}
