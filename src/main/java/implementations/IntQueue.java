package implementations;

public final class IntQueue {
  // FIFO - offer to the end, poll from the front
  private final int[] items;
  private int size = -1;

  public IntQueue(int capacity) {
    items = new int[capacity];
  }

  public final int getCapacity() {
    return items.length;
  }

  public final int getSize() {
    return size + 1;
  }

  public final void offer(int i) {
    items[++size] = i;
  }

  public final int peek() {
    return items[0];
  }

  public final int poll() {
    int item = items[0];
    redistribute();

    return item;
  }

  private void redistribute() {
    if (getSize() == 0) return;

    int index = 0;
    while (index <= getSize()) {
      items[index] = items[++index];
    }
    this.size--;
  }
}
