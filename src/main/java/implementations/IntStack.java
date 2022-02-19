package implementations;

public final class IntStack { // LIFO - push to the front, pop from the front
  private final int[] entries;
  private int index = -1;

  public IntStack(int capacity) {
    entries = new int[capacity];
  }

  public final int capacity() {
    return entries.length;
  }

  public final int size() {
    return index + 1;
  }

  public final void push(int i) {
    entries[++index] = i;
  }

  public final int get() {
    return entries[index];
  }

  public final int pop() {
    return entries[index--];
  }
}
