package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class DiameterOfBinaryTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree(), 3),
        arguments(createCase2Tree(), 1),
        arguments(createCase3Tree(), 0),
        arguments(createCase4Tree(), 1));
  }

  private static DiameterOfBinaryTree.TreeNode createCase1Tree() {
    DiameterOfBinaryTree top = new DiameterOfBinaryTree();
    DiameterOfBinaryTree.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    root.left.left = top.new TreeNode(4);
    root.left.right = top.new TreeNode(5);
    root.right = top.new TreeNode(3);
    return root;
  }

  private static DiameterOfBinaryTree.TreeNode createCase2Tree() {
    DiameterOfBinaryTree top = new DiameterOfBinaryTree();
    DiameterOfBinaryTree.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    return root;
  }

  private static DiameterOfBinaryTree.TreeNode createCase3Tree() {
    DiameterOfBinaryTree top = new DiameterOfBinaryTree();
    return top.new TreeNode(1);
  }

  private static DiameterOfBinaryTree.TreeNode createCase4Tree() {
    DiameterOfBinaryTree top = new DiameterOfBinaryTree();
    DiameterOfBinaryTree.TreeNode root = top.new TreeNode(1);
    root.right = top.new TreeNode(2);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(DiameterOfBinaryTree.TreeNode root, int expected) {
    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new DiameterOfBinaryTree().diameterOfBinaryTree(root));

    Assertions.assertEquals(expected, actual);
  }
}
