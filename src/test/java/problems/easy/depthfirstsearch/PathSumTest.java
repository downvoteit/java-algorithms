package problems.easy.depthfirstsearch;

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
        arguments(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}, 22, true),
        arguments(new Integer[] {1, 2, 3}, 5, false),
        arguments(new Integer[] {}, 0, false),
        arguments(new Integer[] {1}, 0, false),
        arguments(new Integer[] {1, 2}, 1, false),
        arguments(new Integer[] {1, -2, -3, 1, 3, -2, null, -1}, 3, false),
        arguments(new Integer[] {-2, null, -3}, -5, true),
        arguments(new Integer[] {1, -2, -3, 1, 3, -2, null, -1}, -3, false));
  }

  private PathSum.TreeNode arrayToTree(Integer[] input, int i) {
    if (i >= input.length) return null;

    var leftNode = arrayToTree(input, i * 2 + 1);
    var rightNode = arrayToTree(input, i * 2 + 2);

    if (input[i] == null) return new PathSum().new TreeNode();

    return new PathSum().new TreeNode(input[i], leftNode, rightNode);
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(Integer[] input, int targetSum, boolean expected) {
    var root = arrayToTree(input, 0);

    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new PathSum().hasPathSum(root, targetSum));

    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }
}
