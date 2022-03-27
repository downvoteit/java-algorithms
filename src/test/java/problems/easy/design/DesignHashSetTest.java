package problems.easy.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DesignHashSetTest {
  @Test
  public void positiveTest() {
    DesignHashSet.MyHashSet myHashSet = new DesignHashSet().new MyHashSet();

    myHashSet.add(1);
    myHashSet.add(2);
    assertTrue(myHashSet.contains(1));
    assertFalse(myHashSet.contains(3));
    myHashSet.add(2);
    assertTrue(myHashSet.contains(2));
    myHashSet.remove(2);
    assertFalse(myHashSet.contains(2));
  }
}
