package problems.medium;

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
        arguments(
            new Integer[] {3, 9, 20, null, null, 15, 7}, new Integer[][] {{3}, {20, 9}, {15, 7}}),
        arguments(new Integer[] {1}, new Integer[][] {{1}}),
        arguments(new Integer[] {}, new Integer[][] {}));
  }

  private BinaryTreeZigzagLevelOrderTraversal.TreeNode arrayToTree(Integer[] input, int i) {
    if (i >= input.length || input[i] == null) return null;

    var leftNode = arrayToTree(input, i * 2 + 1);
    var rightNode = arrayToTree(input, i * 2 + 2);

    return new BinaryTreeZigzagLevelOrderTraversal().new TreeNode(input[i], leftNode, rightNode);
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(Integer[] input, Integer[][] expected) {
    var root = arrayToTree(input, 0);

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
