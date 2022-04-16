package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreePreorderTraversalTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree(), new Integer[] {1, 2, 3}),
        arguments(createCase2Tree(), new Integer[] {}),
        arguments(createCase3Tree(), new Integer[] {1}));
  }

  private static BinaryTreePreorderTraversal.TreeNode createCase1Tree() {
    BinaryTreePreorderTraversal top = new BinaryTreePreorderTraversal();
    BinaryTreePreorderTraversal.TreeNode root = top.new TreeNode(1);
    root.right = top.new TreeNode(2);
    root.right.left = top.new TreeNode(3);
    return root;
  }

  private static BinaryTreePreorderTraversal.TreeNode createCase2Tree() {
    return null;
  }

  private static BinaryTreePreorderTraversal.TreeNode createCase3Tree() {
    BinaryTreePreorderTraversal top = new BinaryTreePreorderTraversal();
    return top.new TreeNode(1);
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(BinaryTreePreorderTraversal.TreeNode root, Integer[] expected) {
    List<Integer> actualValue =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new BinaryTreePreorderTraversal().preorderTraversal(root));

    Integer[] actual = actualValue.toArray(new Integer[] {});

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(actual));

    Assertions.assertArrayEquals(expected, actual);
  }
}
