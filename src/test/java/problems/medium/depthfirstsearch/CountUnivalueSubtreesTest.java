package problems.medium.depthfirstsearch;

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
        arguments(new Integer[] {5, 1, 5, 5, 5, null, 5}, 4),
        arguments(new Integer[] {}, 0),
        arguments(new Integer[] {5, 5, 5, 5, 5, null, 5}, 6),
        arguments(new Integer[] {1, 1, 1, 5, 5, null, 5}, 3),
        arguments(new Integer[] {5, 1, 3, 1, 1, 1}, 4),
        arguments(
            new Integer[] {
              7, 82, 82, -79, 98, 98, -79, -79, null, -28, -24, -28, -24, null, -79, null, 97, 65,
              -4, null, 3, -4, 65, 3, null, 97
            },
            8));
  }

  private CountUnivalueSubtrees.TreeNode arrayToTree(Integer[] input, int i) {
    if (i >= input.length || input[i] == null) return null;

    var leftNode = arrayToTree(input, i * 2 + 1);
    var rightNode = arrayToTree(input, i * 2 + 2);

    return new CountUnivalueSubtrees().new TreeNode(input[i], leftNode, rightNode);
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(Integer[] input, int expected) {
    var root = arrayToTree(input, 0);

    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new CountUnivalueSubtrees().countUnivalSubtrees(root));

    Assertions.assertEquals(expected, actual);
  }
}