package com.downvoteit.javaalgorithms.interfaces;

public interface QuickUnionUndirectedTree {
  int find(int vertex);

  boolean union(int vertex1, int vertex2);

  boolean hasMinVertices();

  default boolean isConnected(int vertex1, int vertex2) {
    return find(vertex1) == find(vertex2);
  }
}
