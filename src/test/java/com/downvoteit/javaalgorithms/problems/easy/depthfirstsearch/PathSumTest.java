package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class PathSumTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree(), 22, true),
        arguments(createCase2Tree(), 5, false),
        arguments(createCase3Tree(), 0, false),
        arguments(createCase4Tree(), 0, false),
        arguments(createCase5Tree(), 1, false),
        arguments(createCase6Tree(), 3, false),
        arguments(createCase7Tree(), -5, true));
  }

  private static PathSum.TreeNode createCase1Tree() {
    PathSum top = new PathSum();
    PathSum.TreeNode root = top.new TreeNode(5);
    root.left = top.new TreeNode(4);
    root.left.left = top.new TreeNode(11);
    root.left.left.left = top.new TreeNode(7);
    root.left.left.right = top.new TreeNode(2);
    root.right = top.new TreeNode(8);
    root.right.left = top.new TreeNode(13);
    root.right.right = top.new TreeNode(4);
    root.right.right.right = top.new TreeNode(1);
    return root;
  }

  private static PathSum.TreeNode createCase2Tree() {
    PathSum top = new PathSum();
    PathSum.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    root.right = top.new TreeNode(3);
    return root;
  }

  private static PathSum.TreeNode createCase3Tree() {
    return null;
  }

  private static PathSum.TreeNode createCase4Tree() {
    PathSum top = new PathSum();
    return top.new TreeNode(1);
  }

  private static PathSum.TreeNode createCase5Tree() {
    PathSum top = new PathSum();
    PathSum.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    return root;
  }

  private static PathSum.TreeNode createCase6Tree() {
    PathSum top = new PathSum();
    PathSum.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(-2);
    root.left.left = top.new TreeNode(1);
    root.left.right = top.new TreeNode(3);
    root.left.left.left = top.new TreeNode(-1);
    root.right = top.new TreeNode(-3);
    root.right.left = top.new TreeNode(-2);
    return root;
  }

  private static PathSum.TreeNode createCase7Tree() {
    PathSum top = new PathSum();
    PathSum.TreeNode root = top.new TreeNode(-2);
    root.right = top.new TreeNode(-3);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(PathSum.TreeNode root, int targetSum, boolean expected) {
    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new PathSum().hasPathSum(root, targetSum));

    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }
}
