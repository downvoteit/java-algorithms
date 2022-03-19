package problems.medium.depthfirstsearch;

// https://leetcode.com/problems/count-univalue-subtrees/
public class CountUnivalueSubtrees {
  public int countUnivalSubtrees(TreeNode root) {
    return new V1().countUnivalSubtrees(root);
  }

  static class V1 extends CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
      return 0;
    }
  }

  public class TreeNode {
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
  }
}
