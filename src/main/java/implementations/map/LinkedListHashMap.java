package implementations.map;

import java.util.ArrayList;
import java.util.List;

public final class LinkedListHashMap<K, V> {
  private final int capacity;
  private final List<Bucket<K, V>> table;

  public LinkedListHashMap() {
    this(8);
  }

  public LinkedListHashMap(int capacity) {
    this.capacity = capacity;
    this.table = new ArrayList<>();

    for (int i = 0; i < capacity; i++) {
      table.add(new Bucket<>());
    }
  }

  public void put(K key, V value) {
    table.get(hash(key)).update(key, value);
  }

  public V get(K key) {
    return table.get(hash(key)).get(key);
  }

  public void remove(K key) {
    table.get(hash(key)).remove(key);
  }

  private int hash(K key) {
    int hash = key.hashCode();

    return (hash & 0x7FFFFFFF) % table.size();
  }

  @Override
  public String toString() {
    return "HashMap{" + table + '}';
  }
}
