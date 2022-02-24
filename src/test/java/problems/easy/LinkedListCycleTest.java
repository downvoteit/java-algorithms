package problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LinkedListCycleTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {3, 2, 0, -4}, 1, true),
        arguments(new int[] {1, 2}, 0, true),
        arguments(new int[] {1}, -1, false));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int pos, boolean expected) {
    LinkedListCycle.ListNode head = new LinkedListCycle().new ListNode(1);

    boolean actual = new LinkedListCycle().hasCycle(head);

    Assertions.assertEquals(expected, actual);
  }
}
