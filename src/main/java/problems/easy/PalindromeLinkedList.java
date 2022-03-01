package problems.easy;

// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    return new V1().isPalindrome(head);
  }

  // time O(n+log n) space O(n)
  // two pointers
  static class V1 extends PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
      StringBuilder s = new StringBuilder();

      ListNode pointer = head;
      while (pointer != null) {
        s.append(pointer.val);

        pointer = pointer.next;
      }

      for (int i = 0; i < s.length() / 2; i++)
        if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
          return false;
        }

      return true;
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
