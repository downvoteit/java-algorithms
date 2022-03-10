package problems.easy.depthfirstsearch;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthOfBinaryTree {
  public int minDepth(TreeNode root) {
    return new V1().minDepth(root);
  }

  static class V1 extends MinimumDepthOfBinaryTree {
    int min = 1;

    public int minDepth(TreeNode root) {
      if (root == null) return 0;

      //      System.out.println(root);

      recurse(root, min);

      return min;
    }

    private void recurse(TreeNode node, int depth) {
      if (node == null) return;

      if (node.left == null && node.right == null) {
        //        System.out.println(node.val + " " + depth);

        min = Math.min(min, depth);
      }

      recurse(node.left, depth + 1);
      recurse(node.right, depth + 1);
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

    @Override
    public String toString() {
      return "{" + "v=" + val + ", l=" + left + ", r=" + right + '}';
    }
  }
}
