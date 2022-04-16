package com.downvoteit.javaalgorithms.problems.easy.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/design-hashset/
public class DesignHashSet {
  class MyHashSet {
    private final int capacity;
    private final List<Bucket> table;
    private int size;

    public MyHashSet() {
      this(128);
    }

    public MyHashSet(int capacity) {
      this.capacity = capacity;
      this.table = new ArrayList<>(capacity);

      for (int i = 0; i < this.capacity; i++) {
        table.add(new Bucket());
      }
    }

    public void add(int key) {
      table.get(hash(key)).add(key);
      size++;
    }

    public void remove(int key) {
      table.get(hash(key)).remove(key);
      size--;
    }

    public boolean contains(int key) {
      return table.get(hash(key)).contains(key);
    }

    private int hash(int key) {
      return (key & 0x7FFFFFFF) % capacity;
    }

    @Override
    public String toString() {
      return "MyHashSet" + table;
    }

    private class Bucket {
      private final LinkedList<Integer> bucket = new LinkedList<>();

      private void add(Integer key) {
        if (!bucket.contains(key)) {
          bucket.add(key);
        }
      }

      private void remove(Integer key) {
        bucket.remove(key);
      }

      private boolean contains(Integer key) {
        return bucket.contains(key);
      }

      @Override
      public String toString() {
        return bucket.toString();
      }
    }
  }
}
