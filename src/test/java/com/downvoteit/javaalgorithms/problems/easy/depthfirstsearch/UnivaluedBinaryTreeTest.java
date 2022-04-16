package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class UnivaluedBinaryTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(arguments(createCase1Tree(), true), arguments(createCase2Tree(), false));
  }

  private static UnivaluedBinaryTree.TreeNode createCase1Tree() {
    UnivaluedBinaryTree top = new UnivaluedBinaryTree();
    UnivaluedBinaryTree.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(1);
    root.left.left = top.new TreeNode(1);
    root.left.right = top.new TreeNode(1);
    root.right = top.new TreeNode(1);
    root.right.right = top.new TreeNode(1);
    return root;
  }

  private static UnivaluedBinaryTree.TreeNode createCase2Tree() {
    UnivaluedBinaryTree top = new UnivaluedBinaryTree();
    UnivaluedBinaryTree.TreeNode root = top.new TreeNode(2);
    root.left = top.new TreeNode(2);
    root.left.left = top.new TreeNode(5);
    root.left.right = top.new TreeNode(2);
    root.right = top.new TreeNode(2);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(UnivaluedBinaryTree.TreeNode root, boolean expected) {

    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new UnivaluedBinaryTree().isUnivalTree(root));

    Assertions.assertEquals(expected, actual);
  }
}
