package problems.easy.unsolved;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    return null;
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
