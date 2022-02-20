package implementations.various;

import java.util.ArrayList;
import java.util.List;

public class StringUtility {
  public List<List<Integer>> stringToIntListInIntList(String s) {
    List<List<Integer>> outer = new ArrayList<>();

    String[] x1 = s.split("#");

    if (x1.length == 0 || x1[0].equals("")) return new ArrayList<>();

    for (String x2 : x1) {
      List<Integer> inner = new ArrayList<>();

      String[] x3 = x2.split(",");

      if (x3[0].equals("")) {
        continue;
      }

      for (String x4 : x3) {
        inner.add(Integer.parseInt(x4));
      }

      outer.add(inner);
    }

    return outer;
  }

  public String integerTo32BitBinaryString(int num) {
    String x1 = Integer.toBinaryString(num);
    String x2 = "0".repeat(32 - x1.length()).concat(x1);
    char[] x3 = x2.toCharArray();
    StringBuilder x4 = new StringBuilder();

    for (int i = 0; i < x2.length(); i++) {
      if (i > 0 && i % 8 == 0) x4.append(" ");
      x4.append(x3[i]);
    }

    return x4.toString();
  }
}
