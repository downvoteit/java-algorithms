# General Snippets

## Continue on duplicates

```
for (i = 1; i < nums.length; i++) {
    if (i > 0 && nums[i - 1] == nums[i]) {
      continue;
    }
    ...
}
```

## Find mid-point

```
int mid = left + right >>> 1;
```

## Include only positive numbers

```
if (num[i] < 0) temp = 0;
```

## Find min/max of two numbers

```
int temp = Math.min(curSum, temp);
```

## Diagonally traverse a 2D-array

```
int posPlane = row + column;
int negPlane = row - column;
```

## In-place substitution by swapping using two indices

```
int temp = nums[i];
nums[i] = nums[j];
nums[j] = temp;
```

## In-place substitution to avoid duplicates

```
int nextNonDupl = 0;
...
if (nums[i - 1] != nums[i]) {
  nums[nextNonDupl++] = nums[i];
}
``` 

## Break-early topmost while-loop

```
TOP:
while (left < right) {
    int next = mid + 1;
    ...
    while (letters[mid] == letters[next]) {
        mid++;
        next = mid + 1;
        
        if (next >= letters.length) {
          break TOP;
        }
    }
}
```

## Recursive, square time, top-down, naive fibonacci number

```
if (n < 2) return n;

return fib(n - 1) + fib(n - 2); 
```

## Recursive, square time, top-down, memoized fibonacci number

```
int dp[] = new int[n + 1];
    
return fib(dp, n);
...
if (n < 2) return n;

if (dp[n] == 0) {
  dp[n] = fib(dp, n - 1) + fib(dp, n - 2);
}

return dp[n];
```

## Iterative, linear time, bottom-up, tabulated fibonacci number

```
if (n < 2) return n;

int dp[] = new int[n + 1];
dp[0] = 0;
dp[1] = 1;

for (int i = 2; i <= n; i++) {
  dp[i] = dp[i - 1] + dp[i - 2];
}

return dp[n];
```

## Iterative, constant time, bottom-up fibonacci number

```
if (n < 2) return num;

int n1 = 0, n2 = 1, temp;

for (int i = 2; i <= n; i++) {
  temp = n1 + n2; // dp[i - 1]
  n1 = n2; //dp[i - 2]
  n2 = temp; // dp[i]
}

return n2;
```

## Two pointers from leftmost and rightmost ends

```
int left = 0, right = nums.length - 1;

while (left < right) {
    int num = nums[left] + nums[right];
    
    if (num == target) {
      return new int[] {left + 1, right + 1};
    } else if (num < target) {
      left++;
    } else {
      right--;
    }
}
```

## Binary search from the middle

```
int left = 0, right = nums.length - 1;

while (left <= right) {
    int mid = (left + right) >>> 1;

    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```

## Union-find count connected components

```
int m, n;
int[] vertices, edges;

public int unionFind(int[][] isConnected) {
    m = n = isConnected.length;
    
    vertices = new int[m];
    size = new int[m];
    for (int i = 0; i < m; i++) {
        vertices[i] = i;
        size[i] = 1;
    }
    
    for (int i = 0; i < m - 1; i++)
        for (int j = i + 1; j < m; j++) {
          if (isConnected[i][j] == 1) union(i, j);
        }
    
    return n;
}

private void union(int p, int q) {
    int i = find(p), j = find(q);
    
    if (i == j) return;
    
    if (size[i] < size[j]) {
        vertices[i] = j;
        size[j] += size[i];
    } else {
        vertices[j] = i;
        size[i] += size[j];
    }
    n--;
}

private int find(int p) {
    while (p != vertices[p]) {
        p = vertices[p];
    }
    
    return p;
}
```

## Find Linked list cycle

```
ListNode fast = head, slow = head;

while (fast != null && fast.next != null) {
    fast = fast.next.next;
    slow = slow.next;
    
    if (slow == fast) return true;
}

return false;
```

## Find Linked list length

```
int listLen = 0;
...
do {
    pointer1 = pointer1.next;
    listLen++;
} while (pointer.next == null && pointer.next != null);
```

## Find Linked list middle

```
ListNode fast = head, slow = head;

while (fast != null && fast.next != null) {
    fast = fast.next.next;
    slow = slow.next;
}

return slow;
```
