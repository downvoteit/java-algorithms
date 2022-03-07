package problems.easy.design;

// https://leetcode.com/problems/implement-stack-using-queues/
public class ImplementStackUsingQueues {
  class MyStack {
    private final int[] items;
    private int size = -1;

    public MyStack() {
      items = new int[10];
    }

    public void push(int x) {
      items[++size] = x;
    }

    public int pop() {
      return items[size--];
    }

    public int top() {
      return items[size];
    }

    public boolean empty() {
      return size <= -1;
    }
  }
}
