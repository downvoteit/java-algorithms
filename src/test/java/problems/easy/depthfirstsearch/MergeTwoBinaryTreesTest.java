package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeTwoBinaryTreesTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree1(), createCase1Tree2(), createCase1Tree3()),
        arguments(createCase2Tree1(), createCase2Tree2(), createCase2Tree3()));
  }

  private static MergeTwoBinaryTrees.TreeNode createCase1Tree1() {
    MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
    MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(3);
    root.left.left = top.new TreeNode(5);
    root.right = top.new TreeNode(2);
    return root;
  }

  private static MergeTwoBinaryTrees.TreeNode createCase1Tree2() {
    MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
    MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(2);
    root.left = top.new TreeNode(1);
    root.left.right = top.new TreeNode(4);
    root.right = top.new TreeNode(3);
    root.right.right = top.new TreeNode(7);
    return root;
  }

  private static MergeTwoBinaryTrees.TreeNode createCase1Tree3() {
    MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
    MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(3);
    root.left = top.new TreeNode(4);
    root.left.left = top.new TreeNode(5);
    root.left.right = top.new TreeNode(4);
    root.right = top.new TreeNode(5);
    root.right.right = top.new TreeNode(7);
    return root;
  }

  private static MergeTwoBinaryTrees.TreeNode createCase2Tree1() {
    MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
    return top.new TreeNode(1);
  }

  private static MergeTwoBinaryTrees.TreeNode createCase2Tree2() {
    MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
    MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    return root;
  }

  private static MergeTwoBinaryTrees.TreeNode createCase2Tree3() {
    MergeTwoBinaryTrees top = new MergeTwoBinaryTrees();
    MergeTwoBinaryTrees.TreeNode root = top.new TreeNode(2);
    root.left = top.new TreeNode(2);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(
      MergeTwoBinaryTrees.TreeNode root1,
      MergeTwoBinaryTrees.TreeNode root2,
      MergeTwoBinaryTrees.TreeNode expected) {
    MergeTwoBinaryTrees.TreeNode actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new MergeTwoBinaryTrees().mergeTrees(root1, root2));

    Assertions.assertEquals(expected, actual);
  }
}
