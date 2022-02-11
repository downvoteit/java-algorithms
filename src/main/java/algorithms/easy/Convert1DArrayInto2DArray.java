package algorithms.easy;

public class Convert1DArrayInto2DArray {
  public int[][] construct2DArray(int[] original, int m, int n) {
    return new V1().construct2DArray(original, m, n);
  }

  static class V1 extends Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int rows, int columns) {
      if (original.length != rows * columns) {
        return new int[][] {};
      }

      int[][] constructed = new int[rows][columns];

      for (int i = 0; i < rows; i++) {
        int j = 0;
        for (int k = i * columns; k <= (i + 1) * columns - 1; k++) {
          constructed[i][j++] = original[k];
        }
      }

      return constructed;
    }
  }
}
