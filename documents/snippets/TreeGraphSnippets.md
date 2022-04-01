# Tree and Graph Snippets

## Example TreeNode

```
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder().append(val);

      if (left != null) sb.append(", left=").append(left);
      if (right != null) sb.append(", right=").append(right);

      return sb.toString();
    }
  }
```

## Construct a tree recursively

```
private TreeNode arrayToTree(Integer[] input, int i) {
    if (i >= input.length || input[i] == null) return null;

    var leftNode = arrayToTree(input, i * 2 + 1);
    var rightNode = arrayToTree(input, i * 2 + 2);

    return new new TreeNode(input[i], leftNode, rightNode);
}
```

## BFS alternate order of array population (left-to-right then right-to-left)

```
Integer[] temp = new Integer[levelSize];
...
if (leftToRight) {
    temp[i] = node.val;
} else {
    temp[temp.length - 1 - i] = node.val;
}
```

### DFS recursive preorder traversal

```
visited.add(node.val);
recurse(node.left, visited);
recurse(node.right, visited);
```

### DFS recursive inorder traversal

```
recurse(node.left, visited);
visited.add(node.val);
recurse(node.right, visited);
````

### DFS recursive postorder traversal

```
recurse(node.left, visited);
recurse(node.right, visited);
visited.add(node.val);
````
