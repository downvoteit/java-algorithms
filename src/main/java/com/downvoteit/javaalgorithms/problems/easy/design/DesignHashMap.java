package com.downvoteit.javaalgorithms.problems.easy.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/design-hashmap/
public class DesignHashMap {
  class MyHashMap {
    private final int capacity;
    private final List<Bucket> table;
    private int size;

    public MyHashMap() {
      this(128);
    }

    public MyHashMap(int capacity) {
      this.capacity = capacity;
      this.table = new ArrayList<>(this.capacity);

      for (int i = 0; i < this.capacity; i++) {
        table.add(new Bucket());
      }
    }

    public void put(int key, int value) {
      table.get(hash(key)).put(key, value);
      size++;
    }

    public int get(int key) {
      return table.get(hash(key)).get(key);
    }

    public void remove(int key) {
      table.get(hash(key)).remove(key);
      size--;
    }

    private int hash(int key) {
      return (key & 0x7FFFFFFF) % capacity;
    }

    @Override
    public String toString() {
      return "MyHashMap" + table;
    }

    private class Bucket {
      private final LinkedList<Pair> bucket;

      public Bucket() {
        this.bucket = new LinkedList<>();
      }

      private void put(int key, int value) {
        boolean found = false;

        for (Pair pair : bucket)
          if (pair.key == key) {
            pair.value = value;
            found = true;
            break;
          }

        if (!found) bucket.add(new Pair(key, value));
      }

      private int get(int key) {
        for (Pair pair : bucket)
          if (pair.key == key) {
            return pair.value;
          }

        return -1;
      }

      private void remove(int key) {
        for (Pair pair : bucket)
          if (pair.key == key) {
            bucket.remove(pair);
            break;
          }
      }

      @Override
      public String toString() {
        return bucket.toString();
      }
    }

    private class Pair {
      private final int key;
      private int value;

      public Pair(int key, int value) {
        this.key = key;
        this.value = value;
      }

      @Override
      public String toString() {
        return key + ":" + value;
      }
    }
  }
}
