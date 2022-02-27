package implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class IntStackTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {1, 2, 3}, new int[] {3, 2, 1}),
        arguments(new int[] {1, 2}, new int[] {2, 1}),
        arguments(new int[] {1}, new int[] {1}),
        arguments(new int[] {}, new int[] {}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int[] expected) {
    IntStack stack = new IntStack(10);
    int[] actual = new int[nums.length];

    for (int i : nums) { // push
      stack.push(i);
    }

    if (nums.length > 0) { // get
      Assertions.assertEquals(stack.get(), nums[nums.length - 1]);
    }

    while (stack.getSize() > 0) { // pop
      actual[actual.length - stack.getSize()] = stack.pop();
    }

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(actual));

    Assertions.assertArrayEquals(expected, actual);
  }
}
