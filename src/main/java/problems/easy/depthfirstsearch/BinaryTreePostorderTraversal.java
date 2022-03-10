package problems.easy.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal {
  public List<Integer> postorderTraversal(TreeNode root) {
    return new V1().postorderTraversal(root);
  }

  static class V1 extends BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> visited = new ArrayList<>();

      recurse(root, visited);

      return visited;
    }

    private void recurse(TreeNode node, List<Integer> visited) {
      if (node == null) return;

      recurse(node.left, visited);
      recurse(node.right, visited);
      visited.add(node.val);
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
