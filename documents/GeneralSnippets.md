# General Snippets

## Continue on duplicates

```
if (i > 0 && nums[i - 1] == nums[i]) {
  continue;
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

## 2D-array diagonal traversal

```
int posPlane = row + column;
int negPlane = row - column;
```

## In-place substitution

```
int nextNonDupl = 0;
...
if (nums[i - 1] != nums[i]) {
  nums[nextNonDupl++] = nums[i];
}
``` 

## Break early top while-loop
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
