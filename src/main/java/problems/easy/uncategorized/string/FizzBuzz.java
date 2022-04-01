package problems.easy.uncategorized.string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/fizz-buzz/
public class FizzBuzz {
  public List<String> fizzBuzz(int n) {
    return new V1().fizzBuzz(n);
  }

  // time O(n) space O(n)
  static class V1 extends FizzBuzz {
    public List<String> fizzBuzz(int n) {
      List<String> list = new ArrayList<>();

      for (int i = 1; i <= n; i++) {
        if (i % 3 == 0 && i % 5 == 0) {
          list.add("FizzBuzz");
        } else if (i % 3 == 0) {
          list.add("Fizz");
        } else if (i % 5 == 0) {
          list.add("Buzz");
        } else {
          list.add(String.valueOf(i));
        }
      }

      return list;
    }
  }
}
