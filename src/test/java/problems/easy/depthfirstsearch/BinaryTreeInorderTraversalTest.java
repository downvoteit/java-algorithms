package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreeInorderTraversalTest {
  static Stream<Arguments> source() {
    var outer = new BinaryTreeInorderTraversal();

    BinaryTreeInorderTraversal.TreeNode root1 = outer.new TreeNode(1);
    root1.right = outer.new TreeNode(2);
    root1.right.left = outer.new TreeNode(3);

    BinaryTreeInorderTraversal.TreeNode root2 = null;
    BinaryTreeInorderTraversal.TreeNode root3 = outer.new TreeNode(1);

    return Stream.of(
        arguments(root1, new Integer[] {1, 3, 2}),
        arguments(root2, new Integer[] {}),
        arguments(root3, new Integer[] {1}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(BinaryTreeInorderTraversal.TreeNode root, Integer[] expected) {
    List<Integer> actualValue =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new BinaryTreeInorderTraversal().inorderTraversal(root));

    Integer[] actual = actualValue.toArray(new Integer[] {});

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(actual));

    Assertions.assertArrayEquals(expected, actual);
  }
}
