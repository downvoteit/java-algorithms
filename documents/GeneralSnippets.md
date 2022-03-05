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
int components, connectedComponents;
int[] vertices, rank;

public int unionFind(int[][] edges) {
    ...
}

// merge two vertexes
// include rank optimization
public void union(int vertex, int vertex2) {
    ...   
}

// find root vertex
// include path compression optimization
public int find(int vertex) {
    ...
}
```

## Check if a String/StringBuilder is palindrome (two pointers)

```
int n = s.length();

for (int i = 0; i < n / 2; i++) 
    if (s.charAt(i) != s.charAt(n - 1 - i)) {
        return false;
    }

return true;
```

## Check if a number is a prime number

```
if (n < 2) return false;
    
for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) return false;
}

return true;
```
