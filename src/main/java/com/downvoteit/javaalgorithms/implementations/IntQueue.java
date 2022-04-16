package com.downvoteit.javaalgorithms.implementations;

// fifo queue
// offer to the end, poll from the front
// time O(1) for offer, peek, poll
// time O(n) for redistribute
public class IntQueue {
  private final int[] items;
  private int size = -1;

  public IntQueue(int capacity) {
    items = new int[capacity];
  }

  public int getSize() {
    return size + 1;
  }

  public void offer(int i) {
    items[++size] = i;
  }

  public int peek() {
    return items[0];
  }

  public int poll() {
    int item = items[0];
    redistribute();

    return item;
  }

  private void redistribute() {
    if (size == -1) return;

    int index = 0;
    while (index <= size + 1) {
      items[index] = items[++index];
    }
    size--;
  }
}
