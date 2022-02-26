package implementations;

class Pair<K, V> {
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
