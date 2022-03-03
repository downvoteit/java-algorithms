package problems.easy;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class RemoveDuplicatesFromSortedListTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/RemoveDuplicatesFromSortedListTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    RemoveDuplicatesFromSortedList.ListNode head;

    if (nums.length == 0) {
      head = new RemoveDuplicatesFromSortedList().new ListNode();
    } else {
      head = new RemoveDuplicatesFromSortedList().new ListNode(nums[0]);
    }

    RemoveDuplicatesFromSortedList.ListNode tail = head;

    for (int i = 1; i < nums.length; i++) {
      tail.next = new RemoveDuplicatesFromSortedList().new ListNode(nums[i]);
      tail = tail.next;
    }

    RemoveDuplicatesFromSortedList.ListNode actual =
        new RemoveDuplicatesFromSortedList().deleteDuplicates(head);

    if (expected.length > 0) {
      Assertions.assertEquals(expected[0], actual.val);
    } else {
      Assertions.assertNull(actual);
    }

    int index = 0;
    while (actual != null && actual.next != null) {
      Assertions.assertEquals(expected[index++], actual.val);

      actual = actual.next;
    }
  }
}
