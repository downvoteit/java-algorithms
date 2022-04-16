package com.downvoteit.javaalgorithms.problems.easy.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidPalindromeTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments("A man, a plan, a canal: Panama", true),
        arguments("race a car", false),
        arguments(" ", true),
        arguments("ab_a", true));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(String s, boolean expected) {
    boolean actual = new ValidPalindrome().isPalindrome(s);

    Assertions.assertEquals(expected, actual);
  }
}
