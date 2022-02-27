package problems.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImplementQueueUsingStacksTest {
  @Test
  public void positiveTest() {
    ImplementQueueUsingStacks.MyQueue myStack = new ImplementQueueUsingStacks().new MyQueue();

    myStack.push(1);
    myStack.push(2);
    Assertions.assertEquals(myStack.peek(), 1);
    myStack.pop();
    Assertions.assertEquals(myStack.peek(), 2);
    Assertions.assertFalse(myStack.empty());
  }
}
