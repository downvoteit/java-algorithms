package implementations;

public final class IntStack {
  // LIFO - push to the front, pop from the front
  private final int[] items;
  private int size = -1;

  public IntStack(int capacity) {
    items = new int[capacity];
  }

  public final int getCapacity() {
    return items.length;
  }

  public final int getSize() {
    return size + 1;
  }

  public final void push(int i) {
    items[++size] = i;
  }

  public final int get() {
    return items[size];
  }

  public final int pop() {
    return items[size--];
  }
}
