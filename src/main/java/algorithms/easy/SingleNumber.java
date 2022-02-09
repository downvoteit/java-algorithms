package algorithms.easy;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    return singleNumberV1(nums);
  }

  // xor time O(1) space O(1)
  private int singleNumberV1(int[] nums) {
    int num = 0;

    for (int value : nums) {
      num = num ^ value;
    }

    return num;
  }
}
