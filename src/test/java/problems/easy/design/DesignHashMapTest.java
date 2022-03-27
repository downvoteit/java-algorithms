package problems.easy.design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DesignHashMapTest {
  @Test
  public void positiveTest() {
    DesignHashMap.MyHashMap myHashMap = new DesignHashMap().new MyHashMap();

    myHashMap.put(1, 1);
    myHashMap.put(2, 2);
    Assertions.assertEquals(1, myHashMap.get(1));
    Assertions.assertEquals(-1, myHashMap.get(3));
    myHashMap.put(2, 1);
    Assertions.assertEquals(1, myHashMap.get(2));
    myHashMap.remove(2);
    Assertions.assertEquals(-1, myHashMap.get(2));
  }
}
