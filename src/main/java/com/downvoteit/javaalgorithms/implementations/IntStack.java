package com.downvoteit.javaalgorithms.implementations;

// lifo stack
// push to the front, pop from the front
// time O(1) for push, get, pop
public class IntStack {
  private final int[] items;
  private int size = -1;

  public IntStack(int capacity) {
    items = new int[capacity];
  }

  public int getSize() {
    return size + 1;
  }

  public void push(int i) {
    items[++size] = i;
  }

  public int get() {
    return items[size];
  }

  public int pop() {
    return items[size--];
  }
}
