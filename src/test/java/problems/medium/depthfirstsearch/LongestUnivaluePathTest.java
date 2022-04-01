package problems.medium.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestUnivaluePathTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(createCase1Tree(), 2),
        arguments(createCase2Tree(), 2),
        arguments(createCase3Tree(), 0),
        arguments(createCase4Tree(), 0),
        arguments(createCase5Tree(), 2));
  }

  private static LongestUnivaluePath.TreeNode createCase1Tree() {
    LongestUnivaluePath top = new LongestUnivaluePath();
    LongestUnivaluePath.TreeNode root = top.new TreeNode(5);
    root.left = top.new TreeNode(4);
    root.left.left = top.new TreeNode(1);
    root.left.right = top.new TreeNode(1);
    root.right = top.new TreeNode(5);
    root.right.right = top.new TreeNode(5);
    return root;
  }

  private static LongestUnivaluePath.TreeNode createCase2Tree() {
    LongestUnivaluePath top = new LongestUnivaluePath();
    LongestUnivaluePath.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(4);
    root.left.left = top.new TreeNode(4);
    root.left.right = top.new TreeNode(4);
    root.right = top.new TreeNode(5);
    root.right.right = top.new TreeNode(5);
    return root;
  }

  private static LongestUnivaluePath.TreeNode createCase3Tree() {
    LongestUnivaluePath top = new LongestUnivaluePath();
    return top.new TreeNode(1);
  }

  private static LongestUnivaluePath.TreeNode createCase4Tree() {
    LongestUnivaluePath top = new LongestUnivaluePath();
    LongestUnivaluePath.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    return root;
  }

  private static LongestUnivaluePath.TreeNode createCase5Tree() {
    LongestUnivaluePath top = new LongestUnivaluePath();
    LongestUnivaluePath.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    root.left.left = top.new TreeNode(2);
    root.left.right = top.new TreeNode(2);
    root.right = top.new TreeNode(2);
    root.right.left = top.new TreeNode(2);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(LongestUnivaluePath.TreeNode root, int expected) {
    int actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new LongestUnivaluePath().longestUnivaluePath(root));

    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }
}
