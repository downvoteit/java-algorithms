package problems.easy.depthfirstsearch;

// https://leetcode.com/problems/merge-two-binary-trees/
public class MergeTwoBinaryTrees {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    return new V1().mergeTrees(root1, root2);
  }

  // time O(n) space O(n)
  static class V1 extends MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      if (root1 == null && root2 == null) return null;

      int newVal = 0;
      TreeNode left1 = null, left2 = null;
      TreeNode right1 = null, right2 = null;

      if (root1 != null) {
        newVal += root1.val;
        left1 = root1.left;
        right1 = root1.right;
      }

      if (root2 != null) {
        newVal += root2.val;
        left2 = root2.left;
        right2 = root2.right;
      }

      return new TreeNode(newVal, mergeTrees(left1, left2), mergeTrees(right1, right2));
    }
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof TreeNode) {
        return obj.toString().equals(this.toString());
      }

      return false;
    }

    @Override
    public String toString() {
      return "("
          + val
          + (left == null ? "" : ", l" + left)
          + (right == null ? "" : ", r" + right)
          + ')';
    }
  }
}
