package implementations.map;

import java.util.LinkedList;
import java.util.List;

class Bucket<K, V> {
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
