package problems.easy.uncategorized.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/
public class MajorityElement {
  public int majorityElement(int[] nums) {
    return new V1().majorityElement(nums);
  }

  // time O(n) space O(n)
  static class V1 extends MajorityElement {
    public int majorityElement(int[] nums) {
      Arrays.sort(nums);

      int num = 0, count = 0;

      Map<Integer, Integer> map = new HashMap<>();

      for (int value : nums)
        if (map.containsKey(value)) {
          map.put(value, map.get(value) + 1);
        } else {
          map.put(value, 1);
        }

      for (int i : map.keySet())
        if (map.get(i) > count) {
          num = i;
          count = map.get(i);
        }

      return num;
    }
  }
}
