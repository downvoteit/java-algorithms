package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumDepthOfBinaryTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new Integer[] {3, 9, 20, null, null, 15, 7}, 2),
        arguments(new Integer[] {2, null, 3, null, 4, null, 5, null, 6}, 5));
  }

  private MinimumDepthOfBinaryTree.TreeNode arrayToTree(Integer[] input, int i) {
    if (i >= input.length || input[i] == null) return null;

    var leftNode = arrayToTree(input, i * 2 + 1);
    var rightNode = arrayToTree(input, i * 2 + 2);

    return new MinimumDepthOfBinaryTree().new TreeNode(input[i], leftNode, rightNode);
  }

  // 1, 3, 5, 7
  // 2, 4, 6, 8
  void test(Integer[] input) {

    for (int i = 0; i < input.length; i = i * 2 + 1) {
      System.out.println(i);
    }

    System.out.println();
    for (int i = 0; i < input.length; i = i * 2 + 2) {
      System.out.println(i);
    }
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(Integer[] input, int expected) {
    var root = arrayToTree(input, 0);

    test(input);

    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new MinimumDepthOfBinaryTree().minDepth(root));

    Assertions.assertEquals(expected, actual);
  }
}
