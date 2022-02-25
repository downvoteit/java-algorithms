# Bit Manipulation Pattern Snippets

## AND (&)

### Count set bits in a number

#### Brian Kernighan’s algorithm

```
int len = 0;

while (num > 0) {
    num &= (num - 1);

    len++;
}
```

#### Lookup table approach

```
int[] table = new int[256];
table[0] = 0;

for (int i = 1; i < 256; i++) {
    table[i] = (i & 1) + table[i >> 1]; // i >> 1 equals to i/2
}

int res = 0; 
for (int i = 0; i < 4; i++) { 
    res += table[n & 0xff]; 

    n >>= 8; 
} 

```

### Count 1s in binary form of every number in range [0, n]

```
int[] res = new int[num + 1];

for (int i = 0; i <= num; i++) {
    int len = 0;

    while (num > 0) {
        num &= (n - 1);
        len++;
    }

    res[i] = len;
}
```

### Check if a number is even/odd

```
boolean res = (n & 1) == 0;
```

### Check if a number is a power of 2 or not

#### Brute-force/naive approach

```
if (num == 0) return false;
    
while (num != 1) {
    if (num % 2 != 0) {
        return false;
    }
    n >>= 1;
}

return true;
```

#### Brian Kernighan’s algorithm

```
boolean res = num != 0 && (num & (n - 1)) == 0;
```

#### Brian Kernighan’s algorithm (ignore negatives)

```
boolean res = num > 0 && (num & (n - 1)) == 0;
```

## OR (|)

### Find number of flips required to make a|b equal to c

```
int res = 0;

for (int i = 0; i < 32; i++) {
    int bitC = ((c >> i) & 1);
    int bitA = ((a >> i) & 1);
    int bitB = ((b >> i) & 1);

    if ((bitA | bitB) != bitC) {
        res += (bitC == 0) ? (bitA == 1 && bitB == 1) ? 2 : 1 : 1;
    }
}
```

## NOT (~)

### Switch sign of a number

```
int num = ~x + 1;
```

## XOR (^)

### Swap two numbers

```
int x = 10, y = 121;
x = x ^ y;
y = y ^ x;
x = x ^ y;
```

### Find odd repeating number

```
int[] nums = new int[] {4, 3, 3, 4, 4, 4, 5, 3, 5};

int res = 0;
for (int num : nums) {
    res ^= num;
}
```

### Find if two numbers have opposite sign

```
int x = 100, y = -1;

boolean res = (x ^ y) < 0;
```

### Find the number of positions where the bits are different


#### Bit Shifting

```
int xor = x ^ y;
int num = 0;

while (xor != 0) {
    if (xor % 2 == 1) {
        num++;
    }
    xor >>= 1;
}
```

#### Brian Kernighan’s Algorithm

```
int xor = x ^ y;
int num = 0;

while (xor != 0) {
    num++;
    xor &= (xor - 1); 
}
```

### Find a single number

```
int xor = 0;

for (int num : nums) {
    xor ^= num;
}
```

### Find a missing number 

```
int num = nums.length;

for (int i = 0; i < nums.length; i++) {
    num ^= i ^ nums[i];
}
```

## Bit shifting (<<, >>, >>>)

### Multiple x by 2^y (Arithmetic left-shift)

```
int num = x << y;
```

### Divide x by 2^y without preserving the sign (Logical right-shift)

```
int num = x >>> y;
```


### Divide x by 2^y while preserving the sign (Arithmetic right-shift)

```
int num = x >> y;
```

### Find bit length of a number (Arithmetic left-shift)

```
int len = 0;

while ((1 << len) <= num) {
    len++;
} 
```

### Check if kth bit is set/unset (Arithmetic left-shift)

```
boolean res = (num & (1 << (k - 1))) != 0;
```

### Find all possible subsets/power sets of a given array without duplicates (Arithmetic left-shift)

```
List<List<Integer>> res = new ArrayList<>();

int num = nums.length;
int powSize = (int) Math.pow(2, num);

for (int i = 0; i < powSize; i++) {
  List<Integer> temp = new ArrayList<>();

  for (int j = 0; j < num; j++) {
    if ((i & (1 << j)) != 0) {
      temp.add(nums[j]);
    }
  }

  res.add(temp);
}
```

### Get first set bit position (Arithmetic left-shift)

```
if (num == 0) return 0;

int k = 1;

while (true) {
    if ((num & (1 << (k - 1))) == 0) {
        k++;
    } else {
        return k;
    }
}
```

### Check if kth bit is set/unset (Arithmetic right-shift)

```
boolean res = ((n >> (k - 1)) & 1) == 1;
```

### Get first set bit position (Arithmetic right-shift)

```
if (num == 0) return 0;

int k = 1;

while (true) {
    if (((n >> (k - 1)) & 1) == 0) {
        k++;
    } else {
        return k;
    }
}
```
