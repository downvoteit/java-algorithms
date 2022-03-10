package problems.medium.topologicalsort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class CourseScheduleTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(2, new int[][] {{0, 1}}, true),
        arguments(2, new int[][] {{1, 0}, {0, 1}}, false));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int numCourses, int[][] prerequisites, boolean expected) {
    boolean actual = new CourseSchedule().canFinish(numCourses, prerequisites);

    System.out.println(expected);
    System.out.println(actual);

    Assertions.assertEquals(expected, actual);
  }
}
