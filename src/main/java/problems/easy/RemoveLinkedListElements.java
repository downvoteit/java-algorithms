package problems.easy;

// https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    return null;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
