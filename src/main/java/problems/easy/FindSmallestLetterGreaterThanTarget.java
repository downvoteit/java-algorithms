package problems.easy;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class FindSmallestLetterGreaterThanTarget {
  public char nextGreatestLetter(char[] letters, char target) {
    return new V1().nextGreatestLetter(letters, target);
  }

  // time O(n*k) space O(1)
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Smallest Letter Greater
  // Than Target.
  // Memory Usage: 42.6 MB, less than 76.35% of Java online submissions for Find Smallest Letter
  // Greater Than Target.
  static class V1 {
    public char nextGreatestLetter(char[] letters, char target) {
      if (target > letters[letters.length - 1] || target < letters[0]) {
        return letters[0];
      }

      int left = 0, right = letters.length - 1;

      char letter = 0;

      TOP:
      while (left < right) {
        int mid = left + right >>> 1, next = mid + 1;

        letter = letters[next];

        if (letters[mid] < target) {
          left++;
        } else if (letters[mid] > target) {
          right--;
        } else {
          // ignore duplicates
          while (letters[mid] == letters[next]) {
            mid++;
            next = mid + 1;

            // break early when the next is the end
            if (next >= letters.length) {
              break TOP;
            }
          }

          return letters[next];
        }
      }

      if (target >= letter) {
        letter = letters[0];
      }

      return letter;
    }
  }
}
