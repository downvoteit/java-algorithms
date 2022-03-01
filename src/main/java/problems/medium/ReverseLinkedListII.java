package problems.medium;

// https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    return new V1().reverseBetween(head, left, right);
  }

  static class V1 extends ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
      return null;
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
  }
}
