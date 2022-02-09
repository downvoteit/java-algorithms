package algorithms.easy;

public class MissingNumber {
  public int missingNumber(int[] nums) {
    return missingNumberV2(nums);
  }

  // xor time O(n) space O(1)
  // example {3, 0, 1}, 2
  // 3 ^ (0 ^ 0) ^ (1 ^ 1) ^ (2 ^ 3) =
  // 2 ^ (0 ^ 0) ^ (1 ^ 1) ^ (3 ^ 3) =
  // 2 ^ 0 ^ 0 ^ 0 =
  // 2
  private int missingNumberV2(int[] nums) {
    int num = nums.length;
    for (int i = 0; i < nums.length; i++) num ^= i ^ nums[i];

    return num;
  }

  // xor time O(n) space O(1)
  private int missingNumberV1(int[] nums) {
    int x1 = 1, x2 = nums[0];
    int len = nums.length + 1;

    for (int i = 2; i < len; i++) {
      x1 = x1 ^ i;
    }

    for (int i = 1; i < len - 1; i++) {
      x2 = x2 ^ nums[i];
    }

    return x1 ^ x2;
  }
}
