package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class MinimumDepthOfBinaryTreeTest {
  @Test
  public void positiveTestOne() {
    var top = new MinimumDepthOfBinaryTree();

    // 3(P),
    // 9(L), 20(R),
    // null(L), null(R), 15(L), 7(R)
    var root = top.new TreeNode(3);
    root.left = top.new TreeNode(9);
    root.right = top.new TreeNode(20);
    root.right.left = top.new TreeNode(15);
    root.right.right = top.new TreeNode(7);

    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new MinimumDepthOfBinaryTree().minDepth(root));

    Assertions.assertEquals(2, actual);
  }

  @Test
  public void positiveTestTwo() {
    var top = new MinimumDepthOfBinaryTree();

    // 2(P),
    // null(L), 3(R),
    // null(L), 4(R),
    // null(L), 5(R),
    // null(L), 6(R)
    var root = top.new TreeNode(2);
    root.right = top.new TreeNode(3);
    root.right.right = top.new TreeNode(4);
    root.right.right.right = top.new TreeNode(5);
    root.right.right.right.right = top.new TreeNode(6);

    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new MinimumDepthOfBinaryTree().minDepth(root));

    Assertions.assertEquals(5, actual);
  }
}
