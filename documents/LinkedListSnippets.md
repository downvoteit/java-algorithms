# Linked Lists Snippets

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

## Get node by index

```
ListNode current = head;

for (int i = 0; i < index && current != null; ++i) {
    current = current.next;
}

return current;
```

