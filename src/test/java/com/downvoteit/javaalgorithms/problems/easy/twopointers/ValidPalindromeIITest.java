package com.downvoteit.javaalgorithms.problems.easy.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidPalindromeIITest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments("aba", true),
        arguments("abca", true),
        arguments("abc", false),
        arguments("bebeb", true),
        arguments("deeee", true),
        arguments("eedede", true),
        arguments("eeedee", true),
        arguments("eeeeeeeeeeeedeee", true),
        arguments("aydmda", true));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(String s, boolean expected) {
    boolean actual = new ValidPalindromeII().validPalindrome(s);

    Assertions.assertEquals(expected, actual);
  }
}
