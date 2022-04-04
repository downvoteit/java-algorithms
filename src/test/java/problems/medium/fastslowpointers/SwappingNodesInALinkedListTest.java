package problems.medium.fastslowpointers;

import converters.StringToIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

class SwappingNodesInALinkedListTest {
  @ParameterizedTest
  @CsvFileSource(
      resources = "/problems/SwappingNodesInALinkedListTest.csv",
      numLinesToSkip = 1,
      delimiter = ';')
  public void positiveTest(
      @ConvertWith(StringToIntArray.class) int[] nums,
      int k,
      @ConvertWith(StringToIntArray.class) int[] expected) {
    var head = createLinkedList(nums);

    var expectedValue = createLinkedList(expected);
    var actualValue = new SwappingNodesInALinkedList().swapNodes(head, k);

    System.out.println(expectedValue);
    System.out.println(actualValue);

    Assertions.assertEquals(expectedValue.toString(), actualValue.toString());
  }

  private SwappingNodesInALinkedList.ListNode createLinkedList(int[] nums) {
    var head = new SwappingNodesInALinkedList().new ListNode(nums[0]);
    var tail = head;

    for (int i = 1; i < nums.length; i++) {
      tail.next = new SwappingNodesInALinkedList().new ListNode(nums[i]);
      tail = tail.next;
    }

    return head;
  }
}
