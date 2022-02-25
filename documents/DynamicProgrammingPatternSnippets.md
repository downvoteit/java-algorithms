# Dynamic Programming Pattern Snippets

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
