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

class BinaryTreePostorderTraversalTest {
  static Stream<Arguments> source() {
    var outer = new BinaryTreePostorderTraversal();

    BinaryTreePostorderTraversal.TreeNode root1 = outer.new TreeNode(1);
    root1.right = outer.new TreeNode(2);
    root1.right.left = outer.new TreeNode(3);

    BinaryTreePostorderTraversal.TreeNode root2 = null;
    BinaryTreePostorderTraversal.TreeNode root3 = outer.new TreeNode(1);

    return Stream.of(
        arguments(root1, new Integer[] {3, 2, 1}),
        arguments(root2, new Integer[] {}),
        arguments(root3, new Integer[] {1}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(BinaryTreePostorderTraversal.TreeNode root, Integer[] expected) {
    List<Integer> actualValue =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50),
            () -> new BinaryTreePostorderTraversal().postorderTraversal(root));

    Integer[] actual = actualValue.toArray(new Integer[] {});

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(actual));

    Assertions.assertArrayEquals(expected, actual);
  }
}
