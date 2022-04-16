package com.downvoteit.javaalgorithms.problems.easy.fastslowpointers;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    return new V1().hasCycle(head);
  }

  // time O(n) space O(1)
  static class V1 extends LinkedListCycle {
    public boolean hasCycle(ListNode head) {
      ListNode fast = head, slow = head;

      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if (slow == fast) return true;
      }

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

    @Override
    public String toString() {
      return "ListNode{" + "val=" + val + '}';
    }
  }
}
