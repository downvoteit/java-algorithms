package implementations.datastructures.maps;

import java.util.LinkedList;
import java.util.List;

class LinkedListBucket<K, V> {
  List<KeyValuePair<K, V>> bucket;

  LinkedListBucket() {
    this.bucket = new LinkedList<>();
  }

  V get(K key) {
    for (KeyValuePair<K, V> kv : bucket)
      if (kv.key.equals(key)) {
        return kv.value;
      }

    return null;
  }

  void update(K key, V value) {
    boolean found = false;

    for (KeyValuePair<K, V> kv : bucket)
      if (kv.key.equals(key)) {
        kv.value = value;
        found = true;
      }

    if (!found) {
      bucket.add(new KeyValuePair<>(key, value));
    }
  }

  void remove(K key) {
    for (KeyValuePair<K, V> kv : bucket)
      if (kv.key.equals(key)) {
        bucket.remove(kv);
        break;
      }
  }

  @Override
  public String toString() {
    return bucket.toString();
  }
}
