package problems.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class PathSumIITest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(
            new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1},
            22,
            new Integer[][] {{5, 4, 11, 2}, {5, 8, 4, 5}}),
        arguments(new Integer[] {1, 2, 3}, 5, new Integer[][] {}),
        arguments(new Integer[] {}, 0, new Integer[][] {}));
  }

  private PathSumII.TreeNode arrayToTree(Integer[] input, int i) {
    if (i >= input.length || input[i] == null) return null;

    var leftNode = arrayToTree(input, i * 2 + 1);
    var rightNode = arrayToTree(input, i * 2 + 2);

    return new PathSumII().new TreeNode(input[i], leftNode, rightNode);
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(Integer[] input, int targetSum, Integer[][] expected) {
    var root = arrayToTree(input, 0);

    List<List<Integer>> actualValue =
        Assertions.assertTimeoutPreemptively(
            Duration.ofMillis(50), () -> new PathSumII().pathSum(root, targetSum));

    List<List<Integer>> expectedValue = new ArrayList<>();

    if (expected.length > 0)
      for (Integer[] outer : expected) {
        expectedValue.add(Arrays.asList(outer));
      }

    System.out.println(root);
    System.out.println(expectedValue);
    System.out.println(actualValue);

    Assertions.assertEquals(expectedValue, actualValue);
  }
}
