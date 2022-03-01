package problems.medium;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class LinkedListCycleIITest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/LinkedListCycleIITest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(@ConvertWith(StringToIntArray.class) int[] nums, int expected) {
    LinkedListCycleII.ListNode head = new LinkedListCycleII().new ListNode(nums[0]);
    LinkedListCycleII.ListNode tail = head;

    LinkedListCycleII.ListNode[] nodes = new LinkedListCycleII.ListNode[nums.length];
    nodes[0] = head;

    for (int i = 1; i < nums.length; i++) {
      tail.next = new LinkedListCycleII().new ListNode(nums[i]);
      tail = tail.next;

      nodes[i] = tail;
    }

    if (expected >= 0) {
      tail.next = nodes[expected];

      LinkedListCycleII.ListNode actual = new LinkedListCycleII().detectCycle(head);

      Assertions.assertEquals(nodes[expected], actual);
    } else {
      LinkedListCycleII.ListNode actual = new LinkedListCycleII().detectCycle(head);

      Assertions.assertNull(actual);
    }
  }
}
