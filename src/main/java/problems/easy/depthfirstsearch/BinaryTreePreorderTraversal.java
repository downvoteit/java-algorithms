package problems.easy.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    return new V1().preorderTraversal(root);
  }

  static class V1 extends BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> visited = new ArrayList<>();

      recurse(root, visited);

      return visited;
    }

    private void recurse(TreeNode node, List<Integer> visited) {
      if (node == null) return;

      visited.add(node.val);
      recurse(node.left, visited);
      recurse(node.right, visited);
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
      return "" + val;
    }
  }
}
