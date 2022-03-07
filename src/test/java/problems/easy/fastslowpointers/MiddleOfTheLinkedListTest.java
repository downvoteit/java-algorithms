package problems.easy.fastslowpointers;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class MiddleOfTheLinkedListTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/MiddleOfTheLinkedListTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    MiddleOfTheLinkedList.ListNode head = new MiddleOfTheLinkedList().new ListNode(nums[0]);
    MiddleOfTheLinkedList.ListNode tail = head;

    for (int i = 1; i < nums.length; i++) {
      tail.next = new MiddleOfTheLinkedList().new ListNode(nums[i]);
      tail = tail.next;
    }

    MiddleOfTheLinkedList.ListNode actual = new MiddleOfTheLinkedList().middleNode(head);

    Assertions.assertNotNull(actual);

    int index = 0;
    while (actual.next != null) {
      Assertions.assertEquals(expected[index++], actual.val);

      actual = actual.next;
    }
  }
}
