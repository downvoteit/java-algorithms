package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumDepthOfBinaryTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(arguments(createCase1Tree(), 2), arguments(createCase2Tree(), 5));
  }

  private static MinimumDepthOfBinaryTree.TreeNode createCase1Tree() {
    MinimumDepthOfBinaryTree top = new MinimumDepthOfBinaryTree();
    MinimumDepthOfBinaryTree.TreeNode root = top.new TreeNode(3);
    root.left = top.new TreeNode(9);
    root.right = top.new TreeNode(20);
    root.right.left = top.new TreeNode(15);
    root.right.right = top.new TreeNode(7);
    return root;
  }

  private static MinimumDepthOfBinaryTree.TreeNode createCase2Tree() {
    MinimumDepthOfBinaryTree top = new MinimumDepthOfBinaryTree();
    MinimumDepthOfBinaryTree.TreeNode root = top.new TreeNode(2);
    root.right = top.new TreeNode(3);
    root.right.right = top.new TreeNode(4);
    root.right.right.right = top.new TreeNode(5);
    root.right.right.right.right = top.new TreeNode(6);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(MinimumDepthOfBinaryTree.TreeNode root, int expected) {
    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new MinimumDepthOfBinaryTree().minDepth(root));

    Assertions.assertEquals(expected, actual);
  }
}
