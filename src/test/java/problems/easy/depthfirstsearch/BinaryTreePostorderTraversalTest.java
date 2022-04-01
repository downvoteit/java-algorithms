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
    return Stream.of(
        arguments(createCase1Tree(), new Integer[] {3, 2, 1}),
        arguments(createCase2Tree(), new Integer[] {}),
        arguments(createCase3Tree(), new Integer[] {1}));
  }

  private static BinaryTreePostorderTraversal.TreeNode createCase1Tree() {
    BinaryTreePostorderTraversal top = new BinaryTreePostorderTraversal();
    BinaryTreePostorderTraversal.TreeNode root = top.new TreeNode(1);
    root.right = top.new TreeNode(2);
    root.right.left = top.new TreeNode(3);
    return root;
  }

  private static BinaryTreePostorderTraversal.TreeNode createCase2Tree() {
    return null;
  }

  private static BinaryTreePostorderTraversal.TreeNode createCase3Tree() {
    BinaryTreePostorderTraversal top = new BinaryTreePostorderTraversal();
    return top.new TreeNode(1);
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
