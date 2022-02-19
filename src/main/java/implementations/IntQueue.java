package implementations;

public final class IntQueue { // FIFO - offer to the end, poll from the front
  private final int[] entries;
  private int index = -1;

  public IntQueue(int capacity) {
    entries = new int[capacity];
  }

  public final int capacity() {
    return entries.length;
  }

  public final int size() {
    return index + 1;
  }

  public final void offer(int i) {
    entries[++index] = i;
  }

  public final int peek() {
    return entries[0];
  }

  public final int poll() {
    int value = entries[0];
    redistribute();

    return value;
  }

  private void redistribute() {
    if (size() == 0) return;

    int i = 0;
    while (i <= size()) entries[i] = entries[++i];
    index--;
  }
}
