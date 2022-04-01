package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumDepthOfBinaryTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(arguments(createCase1Tree(), 3), arguments(createCase2Tree(), 2));
  }

  private static MaximumDepthOfBinaryTree.TreeNode createCase1Tree() {
    MaximumDepthOfBinaryTree top = new MaximumDepthOfBinaryTree();
    MaximumDepthOfBinaryTree.TreeNode root = top.new TreeNode(3);
    root.left = top.new TreeNode(9);
    root.right = top.new TreeNode(20);
    root.right.left = top.new TreeNode(15);
    root.right.right = top.new TreeNode(7);
    return root;
  }

  private static MaximumDepthOfBinaryTree.TreeNode createCase2Tree() {
    MaximumDepthOfBinaryTree top = new MaximumDepthOfBinaryTree();
    MaximumDepthOfBinaryTree.TreeNode root = top.new TreeNode(1);
    root.right = top.new TreeNode(2);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(MaximumDepthOfBinaryTree.TreeNode root, int expected) {
    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new MaximumDepthOfBinaryTree().maxDepth(root));

    Assertions.assertEquals(expected, actual);
  }
}
