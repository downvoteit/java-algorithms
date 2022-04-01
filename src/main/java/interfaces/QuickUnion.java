package interfaces;

public interface QuickUnion {
  int find(int vertex);

  void union(int vertex1, int vertex2);

  default boolean isConnected(int vertex1, int vertex2) {
    return find(vertex1) == find(vertex2);
  }
}
