package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumDepthOfBinaryTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new Integer[] {3, 9, 20, null, null, 15, 7}, 3),
        arguments(new Integer[] {1, null, 2}, 2));
  }

  private MaximumDepthOfBinaryTree.TreeNode arrayToTree(Integer[] input, int i) {
    if (i >= input.length || input[i] == null) return null;

    var leftNode = arrayToTree(input, i * 2 + 1);
    var rightNode = arrayToTree(input, i * 2 + 2);

    return new MaximumDepthOfBinaryTree().new TreeNode(input[i], leftNode, rightNode);
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(Integer[] input, int expected) {
    var root = arrayToTree(input, 0);

    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new MaximumDepthOfBinaryTree().maxDepth(root));

    Assertions.assertEquals(expected, actual);
  }
}
