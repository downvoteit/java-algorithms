package problems.easy.depthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    return new V2().inorderTraversal(root);
  }

  // time O(n) space O(n)
  // DFS, iterative, inorder
  static class V2 extends BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> visited = new ArrayList<>();

      LinkedList<TreeNode> stack = new LinkedList<>();
      TreeNode current = root;

      while (current != null || !stack.isEmpty()) {
        while (current != null) {
          stack.push(current);
          current = current.left;
        }

        current = stack.pop();
        visited.add(current.val);
        current = current.right;
      }

      return visited;
    }
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
      return "{" + "v=" + val + ", l=" + left + ", r=" + right + '}';
    }
  }
}
