package problems.easy.depthfirstsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class SameTreeTest {
  @Test
  public void positiveTestOne() {
    var top = new SameTree();

    // 1(P),
    // 2(L), 3(R)
    var rootOne = top.new TreeNode(1);
    rootOne.left = top.new TreeNode(2);
    rootOne.right = top.new TreeNode(3);

    // 1(P),
    // 2(L), 3(R)
    var rootTwo = top.new TreeNode(1);
    rootTwo.left = top.new TreeNode(2);
    rootTwo.right = top.new TreeNode(3);

    System.out.println(rootOne);
    System.out.println(rootTwo);

    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new SameTree().isSameTree(rootOne, rootTwo));

    Assertions.assertTrue(actual);
  }

  @Test
  public void positiveTestTwo() {
    var top = new SameTree();

    // 1(P),
    // 2(L), null(R)
    var rootOne = top.new TreeNode(1);
    rootOne.left = top.new TreeNode(2);

    // 1(P),
    // null(L), 2(R)
    var rootTwo = top.new TreeNode(1);
    rootTwo.right = top.new TreeNode(2);

    System.out.println(rootOne);
    System.out.println(rootTwo);

    boolean actual =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new SameTree().isSameTree(rootOne, rootTwo));

    Assertions.assertFalse(actual);
  }
}
