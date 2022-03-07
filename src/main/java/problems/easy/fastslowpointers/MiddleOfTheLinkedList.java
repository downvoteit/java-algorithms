package problems.easy.fastslowpointers;

// https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfTheLinkedList {
  public ListNode middleNode(ListNode head) {
    return new V2().middleNode(head);
  }

  // time O(n) space O(1)
  // fast and slow pointers, faster terminates sooner
  static class V2 extends MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
      ListNode fast = head, slow = head;

      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }

      return slow;
    }
  }

  // time O(n) space O(1)
  // brute-force, divide length by 2
  static class V1 extends MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
      if (head.next == null) return head;

      int listLen = 0;
      ListNode pointer1 = head, pointer2 = head;

      do {
        pointer1 = pointer1.next;
        listLen++;
      } while (pointer1.next != null);

      double mid = Math.round(listLen / 2.0);

      while (mid > 0) {
        pointer2 = pointer2.next;
        mid--;
      }

      return pointer2;
    }
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
