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
        arguments(createCase1Tree(), new Double[] {3.00000, 14.50000, 11.00000}),
        arguments(createCase2Tree(), new Double[] {3.00000, 14.50000, 11.00000}));
  }

  private static AverageOfLevelsInBinaryTree.TreeNode createCase1Tree() {
    AverageOfLevelsInBinaryTree top = new AverageOfLevelsInBinaryTree();
    AverageOfLevelsInBinaryTree.TreeNode root = top.new TreeNode(3);
    root.left = top.new TreeNode(9);
    root.right = top.new TreeNode(20);
    root.right.left = top.new TreeNode(15);
    root.right.right = top.new TreeNode(7);
    return root;
  }

  private static AverageOfLevelsInBinaryTree.TreeNode createCase2Tree() {
    AverageOfLevelsInBinaryTree top = new AverageOfLevelsInBinaryTree();
    AverageOfLevelsInBinaryTree.TreeNode root = top.new TreeNode(3);
    root.left = top.new TreeNode(9);
    root.left.left = top.new TreeNode(15);
    root.left.right = top.new TreeNode(7);
    root.right = top.new TreeNode(20);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(AverageOfLevelsInBinaryTree.TreeNode root, Double[] expected) {
    List<Double> actualValue =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new AverageOfLevelsInBinaryTree().averageOfLevels(root));

    List<Double> expectedValue = Arrays.asList(expected);

    Assertions.assertEquals(expectedValue, actualValue);
  }
}
