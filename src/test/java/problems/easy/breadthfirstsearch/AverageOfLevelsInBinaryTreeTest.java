package problems.easy.breadthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class AverageOfLevelsInBinaryTreeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(
            new Integer[] {3, 9, 20, null, null, 15, 7},
            new Double[] {3.00000, 14.50000, 11.00000}),
        arguments(new Integer[] {3, 9, 20, 15, 7}, new Double[] {3.00000, 14.50000, 11.00000}));
  }

  private AverageOfLevelsInBinaryTree.TreeNode arrayToTree(Integer[] input, int i) {
    if (i >= input.length || input[i] == null) return null;

    var leftNode = arrayToTree(input, i * 2 + 1);
    var rightNode = arrayToTree(input, i * 2 + 2);

    return new AverageOfLevelsInBinaryTree().new TreeNode(input[i], leftNode, rightNode);
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(Integer[] input, Double[] expected) {
    var root = arrayToTree(input, 0);

    System.out.println(root);

    List<Double> actualValue =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new AverageOfLevelsInBinaryTree().averageOfLevels(root));

    List<Double> expectedValue = Arrays.asList(expected);

    Assertions.assertEquals(expectedValue, actualValue);
  }
}
