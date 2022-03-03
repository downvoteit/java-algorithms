package problems.medium;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
  public ListNode detectCycle(ListNode head) {
    return new V1().detectCycle(head);
  }

  // time O(n) space O(1)
  static class V1 extends LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
      ListNode fast = head, slow = head;

      // find cycle
      int cycleLen = 0;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if (fast == slow) {
          ListNode current = slow;

          // find length
          do {
            current = current.next;

            cycleLen++;
          } while (current != slow);

          break; // if cycle found terminate
        }
      }

      if (cycleLen == 0) return null;

      // find start
      ListNode pointer1 = head, pointer2 = head;
      while (cycleLen > 0) {
        pointer2 = pointer2.next;
        cycleLen--;
      }
      while (pointer1 != pointer2) {
        pointer1 = pointer1.next;
        pointer2 = pointer2.next;
      }

      return pointer1;
    }
  }

  class ListNode {
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
