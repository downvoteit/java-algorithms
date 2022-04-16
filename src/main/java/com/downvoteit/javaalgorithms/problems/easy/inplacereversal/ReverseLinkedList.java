package com.downvoteit.javaalgorithms.problems.easy.inplacereversal;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    return new V1().reverseList(head);
  }

  // time O(n) space O(1)
  static class V1 extends ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
      ListNode previous = null, current = head, next;

      while (current != null) {
        next = current.next; // store temporary next node

        current.next = previous; // reverse the current node
        previous = current; // point previous node to the current node
        current = next; // move to the next node

        System.out.println(next);
      }

      // when current is null previous will become the new head
      return previous;
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
