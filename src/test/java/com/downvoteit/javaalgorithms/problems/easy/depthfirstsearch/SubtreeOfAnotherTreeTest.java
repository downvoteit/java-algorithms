package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SubtreeOfAnotherTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(Case1.createTree1(), Case1.createTree2(), true),
        arguments(Case2.createTree1(), Case2.createTree2(), false),
        arguments(Case3.createTree1(), Case3.createTree2(), true),
        arguments(Case4.createTree1(), Case4.createTree2(), false));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(
      SubtreeOfAnotherTree.TreeNode root1, SubtreeOfAnotherTree.TreeNode root2, boolean expected) {
    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new SubtreeOfAnotherTree().isSubtree(root1, root2));

    System.out.println();
    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }

  static class Case1 {
    private static SubtreeOfAnotherTree.TreeNode createTree1() {
      SubtreeOfAnotherTree top = new SubtreeOfAnotherTree();
      SubtreeOfAnotherTree.TreeNode root = top.new TreeNode(3);
      root.left = top.new TreeNode(4);
      root.left.left = top.new TreeNode(1);
      root.left.right = top.new TreeNode(2);
      root.right = top.new TreeNode(5);
      return root;
    }

    private static SubtreeOfAnotherTree.TreeNode createTree2() {
      SubtreeOfAnotherTree top = new SubtreeOfAnotherTree();
      SubtreeOfAnotherTree.TreeNode root = top.new TreeNode(4);
      root.left = top.new TreeNode(1);
      root.right = top.new TreeNode(2);
      return root;
    }
  }

  static class Case2 {
    private static SubtreeOfAnotherTree.TreeNode createTree1() {
      SubtreeOfAnotherTree top = new SubtreeOfAnotherTree();
      SubtreeOfAnotherTree.TreeNode root = top.new TreeNode(3);
      root.left = top.new TreeNode(4);
      root.left.left = top.new TreeNode(1);
      root.left.right = top.new TreeNode(2);
      root.left.right.left = top.new TreeNode(0);
      root.right = top.new TreeNode(5);
      return root;
    }

    private static SubtreeOfAnotherTree.TreeNode createTree2() {
      SubtreeOfAnotherTree top = new SubtreeOfAnotherTree();
      SubtreeOfAnotherTree.TreeNode root = top.new TreeNode(4);
      root.left = top.new TreeNode(1);
      root.right = top.new TreeNode(2);
      return root;
    }
  }

  static class Case3 {
    private static SubtreeOfAnotherTree.TreeNode createTree1() {
      SubtreeOfAnotherTree top = new SubtreeOfAnotherTree();
      SubtreeOfAnotherTree.TreeNode root = top.new TreeNode(1);
      root.left = top.new TreeNode(1);
      return root;
    }

    private static SubtreeOfAnotherTree.TreeNode createTree2() {
      SubtreeOfAnotherTree top = new SubtreeOfAnotherTree();
      return top.new TreeNode(1);
    }
  }

  static class Case4 {
    private static SubtreeOfAnotherTree.TreeNode createTree1() {
      SubtreeOfAnotherTree top = new SubtreeOfAnotherTree();
      SubtreeOfAnotherTree.TreeNode root = top.new TreeNode(1);
      root.left = top.new TreeNode(2);
      root.right = top.new TreeNode(3);
      return root;
    }

    private static SubtreeOfAnotherTree.TreeNode createTree2() {
      SubtreeOfAnotherTree top = new SubtreeOfAnotherTree();
      SubtreeOfAnotherTree.TreeNode root = top.new TreeNode(1);
      root.left = top.new TreeNode(2);
      return root;
    }
  }
}
