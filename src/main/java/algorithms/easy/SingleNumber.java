package algorithms.easy;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    return new V1().singleNumber(nums);
  }

  static class V1 extends SingleNumber {
    // xor time O(1) space O(1)

    public int singleNumber(int[] nums) {
      int num = 0;

      for (int value : nums) {
        num = num ^ value;
      }

      return num;
    }
  }
}
