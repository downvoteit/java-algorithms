package algorithms;

import java.util.HashMap;
import java.util.Map;

public class VariousTests {
  public static void main(String[] args) {
    String actual = new VariousTests().test("letsleetcode", 2);
    if (!"let".equals(actual)) {
      System.out.println("expected: let, got: " + actual);
    }
  }

  private String test(String s, int k) {
    char[] arr = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();

    for (char c : arr) {
      if (map.containsKey(c)) {
        int count = map.get(c);

        map.put(c, ++count);
      } else {
        map.put(c, 1);
      }
    }

    // t=2, e=4, l=2
    System.out.println(map);

    /*
     t = yes,
     te = no
     tel = no

     e = yes
     et = yes*
     etl = no

    */
    StringBuilder seq = new StringBuilder();
    for (Map.Entry<Character, Integer> e : map.entrySet()) {
      if (e.getValue() > 1) {
        seq.append(e.getKey());

        if (s.length() > 1) {
          if (s.indexOf(seq.toString()) > 0) {
            System.out.println(seq);
          } else {
            seq.deleteCharAt(seq.length() - 1);
          }
        }
      }
    }

    return seq.toString();
  }
}
