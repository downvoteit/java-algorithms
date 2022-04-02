package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class InvertBinaryTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(Case1.createTree1(), Case1.createTree2()),
        arguments(Case2.createTree1(), Case2.createTree2()),
        arguments(Case3.createTree1(), Case3.createTree2()));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(InvertBinaryTree.TreeNode root, InvertBinaryTree.TreeNode expected) {
    InvertBinaryTree.TreeNode actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new InvertBinaryTree().invertTree(root));

    System.out.println();
    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }

  static class Case1 {
    private static InvertBinaryTree.TreeNode createTree1() {
      InvertBinaryTree top = new InvertBinaryTree();
      InvertBinaryTree.TreeNode root = top.new TreeNode(4);
      root.left = top.new TreeNode(2);
      root.left.left = top.new TreeNode(1);
      root.left.right = top.new TreeNode(3);
      root.right = top.new TreeNode(7);
      root.right.left = top.new TreeNode(6);
      root.right.right = top.new TreeNode(9);
      return root;
    }

    private static InvertBinaryTree.TreeNode createTree2() {
      InvertBinaryTree top = new InvertBinaryTree();
      InvertBinaryTree.TreeNode root = top.new TreeNode(4);
      root.left = top.new TreeNode(7);
      root.left.left = top.new TreeNode(9);
      root.left.right = top.new TreeNode(6);
      root.right = top.new TreeNode(2);
      root.right.left = top.new TreeNode(3);
      root.right.right = top.new TreeNode(1);
      return root;
    }
  }

  static class Case2 {
    private static InvertBinaryTree.TreeNode createTree1() {
      InvertBinaryTree top = new InvertBinaryTree();
      InvertBinaryTree.TreeNode root = top.new TreeNode(2);
      root.left = top.new TreeNode(1);
      root.right = top.new TreeNode(3);
      return root;
    }

    private static InvertBinaryTree.TreeNode createTree2() {
      InvertBinaryTree top = new InvertBinaryTree();
      InvertBinaryTree.TreeNode root = top.new TreeNode(2);
      root.left = top.new TreeNode(3);
      root.right = top.new TreeNode(1);
      return root;
    }
  }

  static class Case3 {
    private static InvertBinaryTree.TreeNode createTree1() {
      InvertBinaryTree top = new InvertBinaryTree();
      InvertBinaryTree.TreeNode root = top.new TreeNode(1);
      root.left = top.new TreeNode(2);
      return root;
    }

    private static InvertBinaryTree.TreeNode createTree2() {
      InvertBinaryTree top = new InvertBinaryTree();
      InvertBinaryTree.TreeNode root = top.new TreeNode(1);
      root.right = top.new TreeNode(2);
      return root;
    }
  }
}
