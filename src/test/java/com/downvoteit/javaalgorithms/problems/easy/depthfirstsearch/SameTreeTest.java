package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SameTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree1(), createCase1Tree2(), true),
        arguments(createCase2Tree1(), createCase2Tree2(), false),
        arguments(createCase3Tree1(), createCase3Tree2(), false));
  }

  private static SameTree.TreeNode createCase1Tree1() {
    SameTree top = new SameTree();
    SameTree.TreeNode root = top.new TreeNode(1);
    root.right = top.new TreeNode(2);
    root.right.left = top.new TreeNode(3);
    return root;
  }

  private static SameTree.TreeNode createCase1Tree2() {
    SameTree top = new SameTree();
    SameTree.TreeNode root = top.new TreeNode(1);
    root.right = top.new TreeNode(2);
    root.right.left = top.new TreeNode(3);
    return root;
  }

  private static SameTree.TreeNode createCase2Tree1() {
    SameTree top = new SameTree();
    SameTree.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    return root;
  }

  private static SameTree.TreeNode createCase2Tree2() {
    SameTree top = new SameTree();
    SameTree.TreeNode root = top.new TreeNode(1);
    root.right = top.new TreeNode(2);
    return root;
  }

  private static SameTree.TreeNode createCase3Tree1() {
    SameTree top = new SameTree();
    SameTree.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    root.right = top.new TreeNode(1);
    return root;
  }

  private static SameTree.TreeNode createCase3Tree2() {
    SameTree top = new SameTree();
    SameTree.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(1);
    root.right = top.new TreeNode(2);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(SameTree.TreeNode p, SameTree.TreeNode q, boolean expected) {
    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new SameTree().isSameTree(p, q));

    Assertions.assertEquals(expected, actual);
  }
}
