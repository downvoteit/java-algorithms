package com.downvoteit.javaalgorithms.implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class IntQueueTest {
  static Stream<Arguments> source() {
    return Stream.of(
        arguments(new int[] {1, 2, 3}, new int[] {1, 2, 3}),
        arguments(new int[] {1, 2}, new int[] {1, 2}),
        arguments(new int[] {1}, new int[] {1}),
        arguments(new int[] {}, new int[] {}));
  }

  @ParameterizedTest
  @MethodSource("source")
  public void positiveTest(int[] nums, int[] expected) {
    IntQueue queue = new IntQueue(10);
    int[] actual = new int[nums.length];

    for (int i : nums) { // offer
      queue.offer(i);
    }

    if (nums.length > 0) { // peek
      Assertions.assertEquals(queue.peek(), nums[0]);
    }

    while (queue.getSize() > 0) { // poll
      actual[actual.length - queue.getSize()] = queue.poll();
    }

    System.out.println(Arrays.toString(expected));
    System.out.println(Arrays.toString(actual));

    Assertions.assertArrayEquals(expected, actual);
  }
}
