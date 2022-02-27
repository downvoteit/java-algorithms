package implementations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/design-hashmap/
// https://leetcode.com/problems/design-hashmap/solution/
// need a prime number of buckets to reduce collisions
// time O(1) best case for add, get, remove
// time O(n) worst case for add, get, remove
public class LinkedListHashtable<K, V> {
  private final List<Bucket<K, V>> table;
  private int capacity = 8;
  private int size = 0;

  public LinkedListHashtable(int capacity) {
    this.capacity = capacity;
    this.table = new ArrayList<>(capacity);

    for (int i = 0; i < this.capacity; i++) {
      table.add(new Bucket<>());
    }
  }

  public LinkedListHashtable() {
    this(8);
  }

  public void put(K key, V value) {
    table.get(hash(key)).update(key, value);
    size++;
  }

  public V get(K key) {
    return table.get(hash(key)).get(key);
  }

  public void remove(K key) {
    table.get(hash(key)).remove(key);
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
    return "Hashtable" + table;
  }

  static class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      return key + ":" + value;
    }
  }

  static class Bucket<K, V> {
    List<Pair<K, V>> bucket;

    Bucket() {
      this.bucket = new LinkedList<>();
    }

    V get(K key) {
      for (Pair<K, V> pair : bucket)
        if (pair.key.equals(key)) {
          return pair.value;
        }

      return null;
    }

    void update(K key, V value) {
      boolean found = false;

      for (Pair<K, V> pair : bucket)
        if (pair.key.equals(key)) {
          pair.value = value;
          found = true;
        }

      if (!found) {
        bucket.add(new Pair<>(key, value));
      }
    }

    void remove(K key) {
      for (Pair<K, V> pair : bucket)
        if (pair.key.equals(key)) {
          bucket.remove(pair);
          break;
        }
    }

    @Override
    public String toString() {
      return bucket.toString();
    }
  }
}
