package com.downvoteit.javaalgorithms.problems.easy.design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImplementQueueUsingStacksTest {
  @Test
  public void positiveTest() {
    ImplementQueueUsingStacks.MyQueue myStack = new ImplementQueueUsingStacks().new MyQueue();

    myStack.push(1);
    myStack.push(2);
    Assertions.assertEquals(1, myStack.peek());
    myStack.pop();
    Assertions.assertEquals(2, myStack.peek());
    Assertions.assertFalse(myStack.empty());
  }
}
