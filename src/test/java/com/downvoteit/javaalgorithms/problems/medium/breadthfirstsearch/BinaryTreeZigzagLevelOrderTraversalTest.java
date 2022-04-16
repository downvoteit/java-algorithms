package com.downvoteit.javaalgorithms.problems.medium.breadthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreeZigzagLevelOrderTraversalTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree(), new Integer[][] {{3}, {20, 9}, {15, 7}}),
        arguments(createCase2Tree(), new Integer[][] {{1}}),
        arguments(createCase3Tree(), new Integer[][] {}));
  }

  private static BinaryTreeZigzagLevelOrderTraversal.TreeNode createCase1Tree() {
    BinaryTreeZigzagLevelOrderTraversal top = new BinaryTreeZigzagLevelOrderTraversal();
    BinaryTreeZigzagLevelOrderTraversal.TreeNode root = top.new TreeNode(3);
    root.left = top.new TreeNode(9);
    root.right = top.new TreeNode(20);
    root.right.left = top.new TreeNode(15);
    root.right.right = top.new TreeNode(7);
    return root;
  }

  private static BinaryTreeZigzagLevelOrderTraversal.TreeNode createCase2Tree() {
    BinaryTreeZigzagLevelOrderTraversal top = new BinaryTreeZigzagLevelOrderTraversal();
    return top.new TreeNode(1);
  }

  private static BinaryTreeZigzagLevelOrderTraversal.TreeNode createCase3Tree() {
    return null;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(
      BinaryTreeZigzagLevelOrderTraversal.TreeNode root, Integer[][] expected) {
    List<List<Integer>> actualValue =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50),
            () -> new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));

    List<List<Integer>> expectedValue = new ArrayList<>();

    if (expected.length > 0)
      for (Integer[] outer : expected) {
        expectedValue.add(Arrays.asList(outer));
      }

    System.out.println(root);
    System.out.println(expectedValue);
    System.out.println(actualValue);

    Assertions.assertEquals(expectedValue, actualValue);
  }
}
