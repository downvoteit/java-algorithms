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
    return Stream.of(arguments(createCase1Tree(), true), arguments(createCase2Tree(), false));
  }

  private static SymmetricTree.TreeNode createCase1Tree() {
    SymmetricTree top = new SymmetricTree();
    SymmetricTree.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    root.left.left = top.new TreeNode(3);
    root.left.right = top.new TreeNode(4);
    root.right = top.new TreeNode(2);
    root.right.left = top.new TreeNode(4);
    root.right.right = top.new TreeNode(3);
    return root;
  }

  private static SymmetricTree.TreeNode createCase2Tree() {
    SymmetricTree top = new SymmetricTree();
    SymmetricTree.TreeNode root = top.new TreeNode(1);
    root.left = top.new TreeNode(2);
    root.left.right = top.new TreeNode(3);
    root.right = top.new TreeNode(2);
    root.right.right = top.new TreeNode(3);
    return root;
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(SymmetricTree.TreeNode root, boolean expected) {
    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new SymmetricTree().isSymmetric(root));

    Assertions.assertEquals(expected, actual);
  }
}
