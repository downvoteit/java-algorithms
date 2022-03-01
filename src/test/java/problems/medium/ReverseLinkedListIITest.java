package problems.medium;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class ReverseLinkedListIITest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/ReverseLinkedListIITest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      int left,
      int right,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    if (nums.length == 0) return;

    ReverseLinkedListII.ListNode head = new ReverseLinkedListII().new ListNode(nums[0]);
    ReverseLinkedListII.ListNode tail = head;

    for (int i = 1; i < nums.length; i++) {
      tail.next = new ReverseLinkedListII().new ListNode(nums[i]);
      tail = tail.next;
    }

    ReverseLinkedListII.ListNode actual =
        new ReverseLinkedListII().reverseBetween(head, left, right);

    Assertions.assertNotNull(actual);

    int index = 0;
    while (actual.next != null) {
      Assertions.assertEquals(expected[index++], actual.val);

      actual = actual.next;
    }
  }
}
