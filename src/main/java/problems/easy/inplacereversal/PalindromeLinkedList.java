package problems.easy.inplacereversal;

// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    return new V1().isPalindrome(head);
  }

  // time O(n+log n) space O(n)
  // two pointers
  static class V1 extends PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
      StringBuilder sb = new StringBuilder();

      ListNode pointer = head;
      while (pointer != null) {
        sb.append(pointer.val);

        pointer = pointer.next;
      }

      for (int i = 0; i < sb.length() / 2; i++)
        if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
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
