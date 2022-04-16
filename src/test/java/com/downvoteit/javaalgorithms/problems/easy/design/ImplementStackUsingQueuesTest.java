package com.downvoteit.javaalgorithms.problems.easy.design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImplementStackUsingQueuesTest {
  @Test
  public void positiveTest() {
    ImplementStackUsingQueues.MyStack myStack = new ImplementStackUsingQueues().new MyStack();

    myStack.push(1);
    myStack.push(2);
    Assertions.assertEquals(2, myStack.top());
    myStack.pop();
    Assertions.assertEquals(1, myStack.top());
    Assertions.assertFalse(myStack.empty());
  }
}
