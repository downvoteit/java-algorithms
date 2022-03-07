package problems.easy.inplacereversal;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class ReverseLinkedListTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/ReverseLinkedListTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    ReverseLinkedList.ListNode head;

    if (nums.length == 0) {
      head = new ReverseLinkedList().new ListNode();
    } else {
      head = new ReverseLinkedList().new ListNode(nums[0]);
    }

    ReverseLinkedList.ListNode tail = head;

    for (int i = 1; i < nums.length; i++) {
      tail.next = new ReverseLinkedList().new ListNode(nums[i]);
      tail = tail.next;
    }

    ReverseLinkedList.ListNode actual = new ReverseLinkedList().reverseList(head);

    if (expected.length > 0) {
      Assertions.assertEquals(expected[0], actual.val);
    }

    int index = 0;
    while (actual != null && actual.next != null) {
      Assertions.assertEquals(expected[index++], actual.val);

      actual = actual.next;
    }
  }
}
