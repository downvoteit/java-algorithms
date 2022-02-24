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
