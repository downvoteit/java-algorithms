package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class DiameterOfBinaryTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new Integer[] {1, 2, 3, 4, 5}, 3),
        arguments(new Integer[] {1, 2, 3, 4, 5}, 3),
        arguments(new Integer[] {1, 2}, 1),
        arguments(new Integer[] {1}, 0),
        arguments(new Integer[] {1, null, 2}, 1));
  }

  private DiameterOfBinaryTree.TreeNode arrayToTree(Integer[] input, int i) {
    if (i >= input.length) return null;

    var leftNode = arrayToTree(input, i * 2 + 1);
    var rightNode = arrayToTree(input, i * 2 + 2);

    if (input[i] == null) return new DiameterOfBinaryTree().new TreeNode();

    return new DiameterOfBinaryTree().new TreeNode(input[i], leftNode, rightNode);
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(Integer[] input, int expected) {
    var root = arrayToTree(input, 0);

    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new DiameterOfBinaryTree().diameterOfBinaryTree(root));

    Assertions.assertEquals(expected, actual);
  }
}
