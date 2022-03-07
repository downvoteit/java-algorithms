package problems.easy.fastslowpointers;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class LinkedListCycleTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/LinkedListCycleTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums, int pos, boolean expected) {
    LinkedListCycle.ListNode head = new LinkedListCycle().new ListNode(nums[0]);
    LinkedListCycle.ListNode tail = head;

    LinkedListCycle.ListNode[] nodes = new LinkedListCycle.ListNode[nums.length];
    nodes[0] = head;

    for (int i = 1; i < nums.length; i++) {
      tail.next = new LinkedListCycle().new ListNode(nums[i]);
      tail = tail.next;

      nodes[i] = tail;
    }

    if (pos >= 0) tail.next = nodes[pos];

    boolean actual = new LinkedListCycle().hasCycle(head);

    Assertions.assertEquals(expected, actual);
  }
}
