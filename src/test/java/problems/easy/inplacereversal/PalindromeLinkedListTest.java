package problems.easy.inplacereversal;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class PalindromeLinkedListTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/PalindromeLinkedListTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(@ConvertWith(StringToIntArray.class) int[] nums, boolean expected) {
    PalindromeLinkedList.ListNode head = new PalindromeLinkedList().new ListNode(nums[0]);
    PalindromeLinkedList.ListNode tail = head;

    for (int i = 1; i < nums.length; i++) {
      tail.next = new PalindromeLinkedList().new ListNode(nums[i]);
      tail = tail.next;
    }

    boolean actual = new PalindromeLinkedList().isPalindrome(head);

    Assertions.assertEquals(expected, actual);
  }
}
