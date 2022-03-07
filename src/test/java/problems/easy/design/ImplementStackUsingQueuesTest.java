package problems.easy.design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImplementStackUsingQueuesTest {
  @Test
  public void positiveTest() {
    ImplementStackUsingQueues.MyStack myStack = new ImplementStackUsingQueues().new MyStack();

    myStack.push(1);
    myStack.push(2);
    Assertions.assertEquals(myStack.top(), 2);
    myStack.pop();
    Assertions.assertEquals(myStack.top(), 1);
    Assertions.assertFalse(myStack.empty());
  }
}
