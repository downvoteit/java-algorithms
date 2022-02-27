package implementations;

import java.util.Arrays;

// min queue
// parent: (index - 1) / 2
// left; index * 2 + 1
// right: index * 2 + 2
// time O(1) best case
// time O(log n) worst case
public class IntMinHeap {
  private int capacity = 10;
  private int size = 0;

  private int[] items;

  public IntMinHeap() {
    this.items = new int[capacity];
  }

  private int getLeftChildIndex(int parentIndex) {
    return parentIndex * 2 + 1;
  }

  private int getRightChildIndex(int parentIndex) {
    return parentIndex * 2 + 2;
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  private boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  private boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  private int leftChild(int index) {
    return items[getLeftChildIndex(index)];
  }

  private int rightChild(int index) {
    return items[getLeftChildIndex(index)];
  }

  private int parent(int index) {
    return items[getParentIndex(index)];
  }

  private void swap(int indexOne, int indexTwo) {
    int temp = items[indexOne];
    items[indexOne] = items[indexTwo];
    items[indexTwo] = temp;
  }

  private void ensureExtraCapacity() {
    if (size != capacity) return;

    items = Arrays.copyOf(items, capacity * 2);
    capacity *= 2;
  }

  public int peek() {
    if (size == 0) throw new IllegalStateException();

    return items[0];
  }

  public int poll() {
    if (size == 0) throw new IllegalStateException();

    int item = items[0];
    items[0] = items[size - 1];
    items[size - 1] = 0; // must nullify polled position
    size--;
    heapifyDown();

    return item;
  }

  public void add(int item) {
    ensureExtraCapacity();

    items[size] = item;
    size++;
    heapifyUp();
  }

  private void heapifyUp() {
    int index = size - 1;

    while (hasParent(index) && parent(index) > items[index]) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  private void heapifyDown() {
    int index = 0;

    // if not left-child then also no right-child
    while (hasLeftChild(index)) {
      int smallerChildIndex = getLeftChildIndex(index);

      // if right child smaller than the right child =>
      // smaller child index should be equal to right child index
      if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
        smallerChildIndex = getRightChildIndex(index);
      }

      // if already ordered
      // else heap is still out of order
      // swap index with the smaller child
      // and move down
      if (items[index] < items[smallerChildIndex]) {
        break;
      } else {
        swap(index, smallerChildIndex);
      }

      index = smallerChildIndex;
    }
  }

  public int[] toArray() {
    return Arrays.copyOfRange(items, 0, size);
  }

  @Override
  public String toString() {
    return "IntMinHeap" + Arrays.toString(items);
  }
}
