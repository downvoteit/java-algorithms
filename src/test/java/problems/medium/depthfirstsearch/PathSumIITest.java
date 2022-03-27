package problems.medium.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class PathSumIITest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree(), 22, List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5))),
        arguments(createCase2Tree(), 5, List.of()),
        arguments(createCase3Tree(), 0, List.of()),
        arguments(createCase4Tree(), 12, List.of(List.of(7, 9, -4))));
  }

  private static PathSumII.TreeNode createCase1Tree() {
    PathSumII top = new PathSumII();
    PathSumII.TreeNode root = top.new TreeNode(5);
    root.left = top.new TreeNode(4);
    root.left.left = top.new TreeNode(11);
    root.left.left.left = top.new TreeNode(7);
    root.left.left.right = top.new TreeNode(2);
    root.right = top.new TreeNode(8);
    root.right.left = top.new TreeNode(13);
    root.right.right = top.new TreeNode(4);
    root.right.right.left = top.new TreeNode(5);
    root.right.right.right = top.new TreeNode(1);
    return root;
  }

  private static PathSumII.TreeNode createCase2Tree() {
    PathSumII top = new PathSumII();
    PathSumII.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    root.right = top.new TreeNode(3);
    return root;
  }

  private static PathSumII.TreeNode createCase3Tree() {
    PathSumII top = new PathSumII();
    PathSumII.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    return root;
  }

  private static PathSumII.TreeNode createCase4Tree() {
    PathSumII top = new PathSumII();
    PathSumII.TreeNode root = top.new TreeNode(7);
    root.left = top.new TreeNode(9);
    root.left.left = top.new TreeNode(-6);
    root.left.right = top.new TreeNode(-4);
    root.left.left.left = top.new TreeNode(7);
    root.left.left.right = top.new TreeNode(-2);
    root.left.left.right.left = top.new TreeNode(-6);
    root.right = top.new TreeNode(-8);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(PathSumII.TreeNode root, int targetSum, List<List<Integer>> expected) {
    List<List<Integer>> actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new PathSumII().pathSum(root, targetSum));

    System.out.println();
    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }
}
