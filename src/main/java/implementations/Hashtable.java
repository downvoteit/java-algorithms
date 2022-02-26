package implementations;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/explore/learn/card/hash-table/
// https://leetcode.com/problems/design-hashmap/solution/
// https://www.youtube.com/watch?v=shs0KM3wKv8&list=WL&index=30&ab_channel=HackerRank
// https://www.geeksforgeeks.org/hashing-set-1-introductio/
// https://www.geeksforgeeks.org/index-mapping-or-trivial-hashing-with-negatives-allowed/
// https://www.geeksforgeeks.org/hashing-set-2-separate-chaining/
// https://www.geeksforgeeks.org/hashing-set-3-open-addressing/
// time O(1) best case for add, get, remove
// time O(n) worst case for add, get, remove
// separate chaining with a linked list
public final class Hashtable<K, V> {
  private final List<Bucket<K, V>> table;
  private final int capacity = 8;

  public Hashtable() {
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
    return "HashMap" + table;
  }
}
