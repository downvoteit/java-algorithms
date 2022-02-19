package implementations.datastructures.maps;

class KeyValuePair<K, V> {
  K key;
  V value;

  KeyValuePair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString() {
    return "Pair{" + key + ":" + value + '}';
  }
}
