package com.downvoteit.javaalgorithms.problems.easy.inplacereversal;

import com.downvoteit.javaalgorithms.converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class RemoveLinkedListElementsTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/RemoveLinkedListElementsTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      int val,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    RemoveLinkedListElements.ListNode head;

    if (nums.length == 0) {
      head = new RemoveLinkedListElements().new ListNode();
    } else {
      head = new RemoveLinkedListElements().new ListNode(nums[0]);
    }

    RemoveLinkedListElements.ListNode tail = head;

    for (int i = 1; i < nums.length; i++) {
      tail.next = new RemoveLinkedListElements().new ListNode(nums[i]);
      tail = tail.next;
    }

    RemoveLinkedListElements.ListNode actual =
        new RemoveLinkedListElements().removeElements(head, val);

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
