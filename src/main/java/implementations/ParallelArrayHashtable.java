package implementations;

// Algorithms 4th Edition
// need a prime number of buckets to reduce collisions
// time O(1) best case for add, get, remove
// time O(n) worst case for add, get, remove
public class ParallelArrayHashtable<K, V> {
  private final V[] values;
  private final K[] keys;
  private int capacity = 8;
  private int size = 0;

  @SuppressWarnings("unchecked")
  public ParallelArrayHashtable(int capacity) {
    this.capacity = capacity;
    this.keys = (K[]) new Object[capacity];
    this.values = (V[]) new Object[capacity];
  }

  public ParallelArrayHashtable() {
    this(8);
  }

  public void put(K key, V value) {
    int i;
    for (i = hash(key); keys[i] != null; i = (i + 1) % capacity)
      if (keys[i].equals(key)) {
        values[i] = value;

        return;
      }
    keys[i] = key;
    values[i] = value;
    size++;
  }

  public V get(K key) {
    for (int i = hash(key); keys[i] != null; i = (i + 1) % capacity)
      if (keys[i].equals(key)) {
        return values[i];
      }

    return null;
  }

  public void remove(K key) {
    int i = hash(key);
    while (!key.equals(keys[i])) {
      i = (i + 1) % capacity;
    }
    keys[i] = null;
    values[i] = null;
    i = (i + 1) % capacity;
    while (keys[i] != null) {
      K keyRedo = keys[i];
      V valueRedo = values[i];
      keys[i] = null;
      values[i] = null;
      size--;
      put(keyRedo, valueRedo);
      i = (i + 1) % capacity;
    }
    size--;
  }

  private int hash(K key) {
    int hash = key.hashCode();

    return (hash & 0x7FFFFFFF) % capacity;
  }

  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("Hashtable[");
    for (int i = 0; i < capacity; i++) {
      if (i > 0) s.append(", ");
      if (keys[i] != null) {
        s.append("[").append(keys[i]).append(":").append(values[i]).append("]");
      } else {
        s.append("[]");
      }
    }

    return s.append("]").toString();
  }
}
