package problems.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    return new V1().removeElements(head, val);
  }

  // time O(n) space O(n)
  static class V1 extends RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
      ListNode current = head;

      List<Integer> values = new ArrayList<>();

      while (current != null) {
        if (current.val != val && current.val != 0) values.add(current.val);

        current = current.next;
      }

      if (values.size() == 0) return null;

      ListNode newHead = new ListNode(values.get(0)), newTail = newHead;
      for (int i = 1; i < values.size(); i++) {
        newTail.next = new ListNode(values.get(i));
        newTail = newTail.next;
      }

      return newHead;
    }
  }

  public class ListNode {
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

    @Override
    public String toString() {
      return val + " " + next;
    }
  }
}
