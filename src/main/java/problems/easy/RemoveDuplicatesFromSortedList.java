package problems.easy;

import java.util.Set;
import java.util.TreeSet;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    return new V2().deleteDuplicates(head);
  }

  // time O(n) space O(1)
  static class V2 extends RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
      return null;
    }
  }

  // time O(n) space O(n)
  static class V1 extends RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode current = head;

      Set<Integer> values = new TreeSet<>();

      while (current != null) {
        values.add(current.val);

        current = current.next;
      }

      if (values.size() == 0) return null;

      ListNode newHead = null, newTail = null;
      for (Integer integer : values.toArray(new Integer[0])) {
        if (newHead == null) {
          newHead = new ListNode(integer);
          continue;
        }

        if (newTail == null) newTail = newHead;

        newTail.next = new ListNode(integer);
        newTail = newTail.next;
      }

      return newHead;
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

    @Override
    public String toString() {
      return val + " " + next;
    }
  }
}
