package implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class IntMinHeapTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {}, new int[] {}, new int[] {}),
        arguments(new int[] {0}, new int[] {}, new int[] {0}),
        arguments(new int[] {0}, new int[] {0}, new int[] {}),
        arguments(new int[] {10, 15}, new int[] {10}, new int[] {15}),
        arguments(new int[] {10, 15, 20, 17, 25}, new int[] {10}, new int[] {15, 17, 20, 25}),
        arguments(new int[] {10, 15, 20, 17, 25}, new int[] {10, 15}, new int[] {17, 25, 20}),
        arguments(new int[] {10, 15, 20, 17, 25}, new int[] {10, 15, 17}, new int[] {20, 25}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int[] expectedOne, int[] expectedTwo) {
    IntMinHeap heap = new IntMinHeap();

    for (int i : nums) {
      heap.add(i);
    }

    for (int i : expectedOne) {
      Assertions.assertEquals(i, heap.peek());
      Assertions.assertEquals(i, heap.poll());
    }

    int[] actual = heap.toArray();

    System.out.format("%n%s%n%s%n", Arrays.toString(expectedTwo), Arrays.toString(actual));

    Assertions.assertArrayEquals(expectedTwo, actual);
  }
}
