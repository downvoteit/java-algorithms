package problems.easy.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    return new V1().inorderTraversal(root);
  }

  // time O(n) space O(n)
  // DFS, recursive, inorder
  static class V1 extends BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> visited = new ArrayList<>();

      recurse(root, visited);

      return visited;
    }

    private void recurse(TreeNode node, List<Integer> visited) {
      if (node == null) return;

      recurse(node.left, visited);
      visited.add(node.val);
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
