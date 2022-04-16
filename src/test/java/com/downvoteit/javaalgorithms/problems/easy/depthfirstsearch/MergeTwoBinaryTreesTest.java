package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeTwoBinaryTreesTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(Case1.createTree1(), Case1.createTree2(), Case1.createTree3()),
        arguments(Case2.createTree1(), Case2.createTree2(), Case2.createTree3()),
        arguments(Case3.createTree1(), Case3.createTree2(), Case3.createTree3()));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(
      MergeTwoBinaryTrees.TreeNode root1,
      MergeTwoBinaryTrees.TreeNode root2,
      MergeTwoBinaryTrees.TreeNode expected) {
    MergeTwoBinaryTrees.TreeNode actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new MergeTwoBinaryTrees().mergeTrees(root1, root2));

    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }

  static class Case1 {
    private static MergeTwoBinaryTrees.TreeNode createTree1() {
      MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
      MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(1);
      root.left = top.new TreeNode(3);
      root.left.left = top.new TreeNode(5);
      root.right = top.new TreeNode(2);
      return root;
    }

    private static MergeTwoBinaryTrees.TreeNode createTree2() {
      MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
      MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(2);
      root.left = top.new TreeNode(1);
      root.left.right = top.new TreeNode(4);
      root.right = top.new TreeNode(3);
      root.right.right = top.new TreeNode(7);
      return root;
    }

    private static MergeTwoBinaryTrees.TreeNode createTree3() {
      MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
      MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(3);
      root.left = top.new TreeNode(4);
      root.left.left = top.new TreeNode(5);
      root.left.right = top.new TreeNode(4);
      root.right = top.new TreeNode(5);
      root.right.right = top.new TreeNode(7);
      return root;
    }
  }

  static class Case2 {
    private static MergeTwoBinaryTrees.TreeNode createTree1() {
      MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
      return top.new TreeNode(1);
    }

    private static MergeTwoBinaryTrees.TreeNode createTree2() {
      MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
      MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(1);
      root.left = top.new TreeNode(2);
      return root;
    }

    private static MergeTwoBinaryTrees.TreeNode createTree3() {
      MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
      MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(2);
      root.left = top.new TreeNode(2);
      return root;
    }
  }

  static class Case3 {
    private static MergeTwoBinaryTrees.TreeNode createTree1() {
      MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
      MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(1);
      root.left = top.new TreeNode(2);
      root.left.left = top.new TreeNode(3);
      return root;
    }

    private static MergeTwoBinaryTrees.TreeNode createTree2() {
      MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
      MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(1);
      root.right = top.new TreeNode(2);
      root.right.right = top.new TreeNode(3);
      return root;
    }

    private static MergeTwoBinaryTrees.TreeNode createTree3() {
      MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
      MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(2);
      root.left = top.new TreeNode(2);
      root.left.left = top.new TreeNode(3);
      root.right = top.new TreeNode(2);
      root.right.right = top.new TreeNode(3);
      return root;
    }
  }
}
