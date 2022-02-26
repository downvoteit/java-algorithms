package implementations;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/design-hashmap/solution/
public final class Hashtable<K, V> {
  private final int CAPACITY = 8;
  private final List<Bucket<K, V>> table;

  public Hashtable() {
    this.table = new ArrayList<>();

    for (int i = 0; i < CAPACITY; i++) {
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
