package problems.medium.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidateBinarySearchTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree(), true),
        arguments(createCase2Tree(), false),
        arguments(createCase3Tree(), true),
        arguments(createCase4Tree(), false),
        arguments(createCase5Tree(), true),
        arguments(createCase6Tree(), true),
        arguments(createCase7Tree(), false),
        arguments(createCase8Tree(), true),
        arguments(createCase9Tree(), false),
        arguments(createCase10Tree(), true));
  }

  private static ValidateBinarySearchTree.TreeNode createCase1Tree() {
    ValidateBinarySearchTree top = new ValidateBinarySearchTree();
    ValidateBinarySearchTree.TreeNode root = top.new TreeNode(2);
    root.left = top.new TreeNode(1);
    root.right = top.new TreeNode(3);
    return root;
  }

  private static ValidateBinarySearchTree.TreeNode createCase2Tree() {
    ValidateBinarySearchTree top = new ValidateBinarySearchTree();
    ValidateBinarySearchTree.TreeNode root = top.new TreeNode(5);
    root.left = top.new TreeNode(1);
    root.right = top.new TreeNode(4);
    root.right.left = top.new TreeNode(3);
    root.right.right = top.new TreeNode(6);
    return root;
  }

  private static ValidateBinarySearchTree.TreeNode createCase3Tree() {
    ValidateBinarySearchTree top = new ValidateBinarySearchTree();
    ValidateBinarySearchTree.TreeNode root = top.new TreeNode(3);
    root.left = top.new TreeNode(1);
    root.left.left = top.new TreeNode(0);
    root.left.right = top.new TreeNode(2);
    root.right = top.new TreeNode(5);
    root.right.left = top.new TreeNode(4);
    root.right.right = top.new TreeNode(6);
    return root;
  }

  private static ValidateBinarySearchTree.TreeNode createCase4Tree() {
    ValidateBinarySearchTree top = new ValidateBinarySearchTree();
    ValidateBinarySearchTree.TreeNode root = top.new TreeNode(3);
    root.left = top.new TreeNode(4);
    return root;
  }

  private static ValidateBinarySearchTree.TreeNode createCase5Tree() {
    ValidateBinarySearchTree top = new ValidateBinarySearchTree();
    ValidateBinarySearchTree.TreeNode root = top.new TreeNode(3);
    root.right = top.new TreeNode(4);
    return root;
  }

  private static ValidateBinarySearchTree.TreeNode createCase6Tree() {
    ValidateBinarySearchTree top = new ValidateBinarySearchTree();
    ValidateBinarySearchTree.TreeNode root = top.new TreeNode(3);
    root.right = top.new TreeNode(5);
    return root;
  }

  // [5,4,6,null,null,3,7]
  private static ValidateBinarySearchTree.TreeNode createCase7Tree() {
    ValidateBinarySearchTree top = new ValidateBinarySearchTree();
    ValidateBinarySearchTree.TreeNode root = top.new TreeNode(5);
    root.left = top.new TreeNode(4);
    root.right = top.new TreeNode(6);
    root.right.left = top.new TreeNode(3);
    root.right.right = top.new TreeNode(7);
    return root;
  }

  private static ValidateBinarySearchTree.TreeNode createCase8Tree() {
    ValidateBinarySearchTree top = new ValidateBinarySearchTree();
    ValidateBinarySearchTree.TreeNode root = top.new TreeNode(5);
    root.left = top.new TreeNode(2);
    root.left.left = top.new TreeNode(1);
    root.left.right = top.new TreeNode(4);
    root.left.right.left = top.new TreeNode(3);
    root.right = top.new TreeNode(6);
    root.right.right = top.new TreeNode(7);
    return root;
  }

  private static ValidateBinarySearchTree.TreeNode createCase9Tree() {
    ValidateBinarySearchTree top = new ValidateBinarySearchTree();
    ValidateBinarySearchTree.TreeNode root = top.new TreeNode(2);
    root.left = top.new TreeNode(2);
    root.right = top.new TreeNode(2);
    return root;
  }

  private static ValidateBinarySearchTree.TreeNode createCase10Tree() {
    ValidateBinarySearchTree top = new ValidateBinarySearchTree();
    return top.new TreeNode(Integer.MAX_VALUE);
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(ValidateBinarySearchTree.TreeNode root, boolean expected) {
    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new ValidateBinarySearchTree().isValidBST(root));

    System.out.println();
    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }
}
