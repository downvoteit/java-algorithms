package problems.medium.twopointers;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
public class SwappingNodesInALinkedList {
  public ListNode swapNodes(ListNode head, int k) {
    return new V1().swapNodes(head, k);
  }

  // time O(n) space O(n)
  // plain and dumb, follow-up should perform the swap in-place
  static class V1 extends SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
      List<Integer> list = new ArrayList<>();

      while (head != null) { // traverse the original linked list
        list.add(head.val);
        head = head.next;
      }

      int x = k - 1;

      int temp = list.get(x); // swap at position x from both ends
      list.set(x, list.get(list.size() - x - 1));
      list.set(list.size() - x - 1, temp);

      ListNode newHead = new ListNode(list.get(0));
      ListNode newTail = newHead;

      for (int i = 1; i < list.size(); i++) { // recreate the linked list
        newTail.next = new ListNode(list.get(i));
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
      return "(" + val + (next != null ? ", n" + next : "") + ')';
    }
  }
}
