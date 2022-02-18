package implementations;

import java.util.ArrayList;
import java.util.List;

public class VariousImplementations {
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
}
