package algorithms;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    return singleNumberV1(nums);
  }

  // XOR Time O(1) Space O(1)
  private int singleNumberV1(int[] nums) {
    int num = 0;

    for (int value : nums) {
      num = num ^ value;
    }

    return num;
  }
}
