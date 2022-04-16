package com.downvoteit.javaalgorithms.problems.medium.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountUnivalueSubtreesTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree(), 4),
        arguments(createCase2Tree(), 0),
        arguments(createCase3Tree(), 6),
        arguments(createCase4Tree(), 3),
        arguments(createCase5Tree(), 4));
  }

  private static CountUnivalueSubtrees.TreeNode createCase1Tree() {
    CountUnivalueSubtrees top = new CountUnivalueSubtrees();
    CountUnivalueSubtrees.TreeNode root = top.new TreeNode(5);
    root.left = top.new TreeNode(1);
    root.left.left = top.new TreeNode(5);
    root.left.right = top.new TreeNode(5);
    root.right = top.new TreeNode(5);
    root.right.right = top.new TreeNode(5);
    return root;
  }

  private static CountUnivalueSubtrees.TreeNode createCase2Tree() {
    return null;
  }

  private static CountUnivalueSubtrees.TreeNode createCase3Tree() {
    CountUnivalueSubtrees top = new CountUnivalueSubtrees();
    CountUnivalueSubtrees.TreeNode root = top.new TreeNode(5);
    root.left = top.new TreeNode(5);
    root.left.left = top.new TreeNode(5);
    root.left.right = top.new TreeNode(5);
    root.right = top.new TreeNode(5);
    root.right.right = top.new TreeNode(5);
    return root;
  }

  private static CountUnivalueSubtrees.TreeNode createCase4Tree() {
    CountUnivalueSubtrees top = new CountUnivalueSubtrees();
    CountUnivalueSubtrees.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(1);
    root.left.left = top.new TreeNode(5);
    root.left.right = top.new TreeNode(5);
    root.right = top.new TreeNode(1);
    root.right.right = top.new TreeNode(5);
    return root;
  }

  private static CountUnivalueSubtrees.TreeNode createCase5Tree() {
    CountUnivalueSubtrees top = new CountUnivalueSubtrees();
    CountUnivalueSubtrees.TreeNode root = top.new TreeNode(5);
    root.left = top.new TreeNode(1);
    root.left.left = top.new TreeNode(1);
    root.left.right = top.new TreeNode(1);
    root.right = top.new TreeNode(3);
    root.right.right = top.new TreeNode(1);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(CountUnivalueSubtrees.TreeNode root, int expected) {
    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new CountUnivalueSubtrees().countUnivalSubtrees(root));

    Assertions.assertEquals(expected, actual);
  }
}
