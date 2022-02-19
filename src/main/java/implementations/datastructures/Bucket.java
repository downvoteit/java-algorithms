package implementations.datastructures;

import java.util.LinkedList;
import java.util.List;

class Bucket<K, V> {
  List<Pair<K, V>> bucket;

  Bucket() {
    this.bucket = new LinkedList<>();
  }

  V get(K key) {
    for (Pair<K, V> kv : bucket)
      if (kv.key.equals(key)) {
        return kv.value;
      }

    return null;
  }

  void update(K key, V value) {
    boolean found = false;

    for (Pair<K, V> kv : bucket)
      if (kv.key.equals(key)) {
        kv.value = value;
        found = true;
      }

    if (!found) {
      bucket.add(new Pair<>(key, value));
    }
  }

  void remove(K key) {
    for (Pair<K, V> kv : bucket)
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
