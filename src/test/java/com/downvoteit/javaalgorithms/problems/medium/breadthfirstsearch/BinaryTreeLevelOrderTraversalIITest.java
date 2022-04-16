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

class BinaryTreeLevelOrderTraversalIITest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree(), new Integer[][] {{15, 7}, {9, 20}, {3}}),
        arguments(createCase2Tree(), new Integer[][] {{1}}),
        arguments(createCase3Tree(), new Integer[][] {}));
  }

  private static BinaryTreeLevelOrderTraversalII.TreeNode createCase1Tree() {
    BinaryTreeLevelOrderTraversalII top = new BinaryTreeLevelOrderTraversalII();
    BinaryTreeLevelOrderTraversalII.TreeNode root = top.new TreeNode(3);
    root.left = top.new TreeNode(9);
    root.right = top.new TreeNode(20);
    root.right.left = top.new TreeNode(15);
    root.right.right = top.new TreeNode(7);
    return root;
  }

  private static BinaryTreeLevelOrderTraversalII.TreeNode createCase2Tree() {
    BinaryTreeLevelOrderTraversalII top = new BinaryTreeLevelOrderTraversalII();
    return top.new TreeNode(1);
  }

  private static BinaryTreeLevelOrderTraversalII.TreeNode createCase3Tree() {
    return null;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(BinaryTreeLevelOrderTraversalII.TreeNode root, Integer[][] expected) {
    List<List<Integer>> actualValue =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50),
            () -> new BinaryTreeLevelOrderTraversalII().levelOrderBottom(root));

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
