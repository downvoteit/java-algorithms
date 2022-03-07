package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SymmetricTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new Integer[] {1, 2, 2, 3, 4, 4, 3}, true),
        arguments(new Integer[] {1, 2, 2, null, 3, null, 3}, false));
  }

  private SymmetricTree.TreeNode arrayToTree(Integer[] input, int i) {
    if (i >= input.length || input[i] == null) return null;

    var leftNode = arrayToTree(input, i * 2 + 1);
    var rightNode = arrayToTree(input, i * 2 + 2);

    return new SymmetricTree().new TreeNode(input[i], leftNode, rightNode);
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(Integer[] input, boolean expected) {
    var root = arrayToTree(input, 0);

    System.out.println(root);

    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new SymmetricTree().isSymmetric(root));

    Assertions.assertEquals(expected, actual);
  }
}
