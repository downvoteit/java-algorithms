package problems.easy.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class FizzBuzzTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(3, new ArrayList<>(List.of("1", "2", "Fizz"))),
        arguments(5, new ArrayList<>(List.of("1", "2", "Fizz", "4", "Buzz"))),
        arguments(
            15,
            new ArrayList<>(
                List.of(
                    "1",
                    "2",
                    "Fizz",
                    "4",
                    "Buzz",
                    "Fizz",
                    "7",
                    "8",
                    "Fizz",
                    "Buzz",
                    "11",
                    "Fizz",
                    "13",
                    "14",
                    "FizzBuzz"))));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int n, ArrayList<String> expected) {
    List<String> actual = new FizzBuzz().fizzBuzz(n);

    Assertions.assertEquals(expected, actual);
  }
}
