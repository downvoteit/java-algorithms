package problems.easy;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    return new V1().hasCycle(head);
  }

  static class V1 extends LinkedListCycle {
    public boolean hasCycle(ListNode head) {
      return false;
    }
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
