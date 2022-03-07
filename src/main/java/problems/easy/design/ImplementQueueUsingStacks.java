package problems.easy.design;

// https://leetcode.com/problems/implement-queue-using-stacks/
public class ImplementQueueUsingStacks {
  class MyQueue {
    private final int[] items;
    private int size = -1;

    public MyQueue() {
      items = new int[10];
    }

    public void push(int x) {
      items[++size] = x;
    }

    public int pop() {
      int item = items[0];
      redistribute();

      return item;
    }

    private int getSize() {
      return size + 1;
    }

    private void redistribute() {
      if (size == -1) return;

      int index = 0;
      while (index <= size + 1) {
        items[index] = items[++index];
      }
      this.size--;
    }

    public int peek() {
      return items[0];
    }

    public boolean empty() {
      return size <= -1;
    }
  }
}
