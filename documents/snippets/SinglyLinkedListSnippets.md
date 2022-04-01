# Singly Linked Lists Snippets

## Example ListNode

```
public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return val + " " + next;
    }
  }
```

## Find cycle

```
ListNode fast = head, slow = head;

while (fast != null && fast.next != null) {
    fast = fast.next.next;
    slow = slow.next;
    
    if (slow == fast) return true;
}

return false;
```

## Find start of a cycle (Floyd's cycle detection algorithm)

```
// 1 - determine if a cycle if found (k)
// 2 - determine cycle length (l)
...
if (cycleLen == 0) return null;

ListNode pointer1 = head, pointer2 = head;
while (cycleLen > 0) {
    pointer2 = pointer2.next;
    cycleLen--;
}

while (pointer1 != pointer2) {
    pointer1 = pointer1.next;
    pointer2 = pointer2.next;
}

return pointer1;
```

## Find length

```
int listLen = 0;
...
do {
    pointer = pointer.next;
    listLen++;
} while (pointer.next == null && pointer.next != null);
```

## Find middle

```
ListNode fast = head, slow = head;

while (fast != null && fast.next != null) {
    fast = fast.next.next;
    slow = slow.next;
}

return slow;
```

## Get tail node

```
ListNode current = head;

while (current != null && current.next != null) {
    current = current.next.next;
}

return current;
```

## Get node by index

```
ListNode current = head;

for (int i = 0; i < index && current != null; ++i) {
    current = current.next;
}

return current;
```

## Add a node to head

```
ListNode current = new ListNode(val);

current.next = head;
head = current;

return;
```

## Add a node to tail

```
if (head == null) {
    addAtHead(val);

    return;
}

ListNode previous = getTail();
ListNode current = new ListNode(val);

previous.next = current;
```

## Add a node by index

```
if (index == 0) {
    addAtHead(val);

    return;
}

ListNode prev = getNode(index - 1);
if (prev == null) {
    return;
}

ListNode current = new ListNode(val);
ListNode next = previous.next;

current.next = next;
previous.next = current;
```

## Delete a node by index

```
ListNode current = getNode(index);

if (current == null) {
    return;
}

ListNode next = current.next;

if (index == 0) {
    // modify head when deleting the first node.
    head = next;
} else {
    ListNode previous = getNode(index - 1);

    previous.next = next;
}
```
