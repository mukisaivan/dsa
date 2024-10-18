
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

  TreeNode root;

  public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  static BsTreeNode bstRoot;

  public static class BsTreeNode {
    int data;
    BsTreeNode left;
    BsTreeNode right;

    public BsTreeNode(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public void createBinaryTree() {
    TreeNode first = new TreeNode(1);
    TreeNode second = new TreeNode(2);
    TreeNode third = new TreeNode(3);
    TreeNode fourth = new TreeNode(4);
    TreeNode fifth = new TreeNode(5);

    root = first;
    first.left = second;
    first.right = third;

    second.left = fourth;
    second.right = fifth;

  }

  // Pre-order traversal (root, left, right) // Best for serializing or copying a
  // tree
  public void recursivePreOrderTraversal(TreeNode node) {
    if (node == null) { // base case
      return;
    }
    // Display the data of the node
    System.out.print(node.data + " ");
    // Traverse the left subtree
    recursivePreOrderTraversal(node.left);
    // Traverse the right subtree
    recursivePreOrderTraversal(node.right);
  }

  // In-order traversal (left, root, right) // Best for BSTs where you need sorted
  // data.
  public void recursiveInOrderTraversal(TreeNode node) {
    if (node == null) { // base case
      return;
    }
    // Traverse the left subtree
    recursiveInOrderTraversal(node.left);
    // Display the data of the node
    System.out.print(node.data + " ");
    // Traverse the right subtree
    recursiveInOrderTraversal(node.right);
  }

  // Post-order traversal (left, right, root) // Best for deleting or evaluating
  // expression trees.
  public void recursivePostOrderTraversal(TreeNode node) {
    if (node == null) { // base case
      return;
    }
    // Traverse the left subtree
    recursivePostOrderTraversal(node.left);
    // Traverse the right subtree
    recursivePostOrderTraversal(node.right);
    // Display the data of the node (root)
    System.out.print(node.data + " ");
  }

  // Level-order traversal (by level from top to bottom) Best for hierarchical
  // visualization or shortest path algorithms.
  public void levelOrderTraversal(TreeNode root) {
    if (root == null) { // base case
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    System.out.println("root------" + root.data);

    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();
      // Display the data of the current node
      System.out.print(currentNode.data + " ");

      // Add the left child to the queue
      if (currentNode.left != null) {
        queue.add(currentNode.left);
      }

      // Add the right child to the queue
      if (currentNode.right != null) {
        queue.add(currentNode.right);
      }
    }
  }

  public void iterativePreOrderTraversalofBinaryTree(TreeNode node) { // using a stack
    Stack<TreeNode> stack = new Stack<>();
    stack.push(node);
    while (!stack.empty()) {
      TreeNode temp = stack.pop();

      System.out.print(temp.data + " ");

      if (temp.right != null) {
        stack.push(temp.right);
      }
      if (temp.left != null) {
        stack.push(temp.left);
      }
    }
  }

  public void iterativeInOrderTraversalofBinaryTree(TreeNode node) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode temp = root;
    while (!stack.isEmpty() || temp != null) {
      if (temp != null) {
        stack.push(temp);
        temp = temp.left;
      } else {
        temp = stack.pop();
        System.out.print(temp.data + "");
        temp = temp.right;
      }
    }
  }

  public void iterativePostOrderTraversalofBinaryTree(TreeNode rootNode) {
    TreeNode current = rootNode;

    Stack<TreeNode> stack = new Stack<>();
    while (current != null || !stack.empty()) {
      if (current != null) {
        stack.push(current);
        current = current.left;
      } else {
        TreeNode temp = stack.peek().right;
        if (temp == null) {
          temp = stack.pop();
          System.out.print(temp.data + " ");
          while (!stack.empty() && temp == stack.peek().right) {
            temp = stack.pop();
            System.out.print(temp.data + " ");
          }
        } else {
          current = temp;
        }
      }
    }
  }

  // FIND THE MAXIMUM VALUE IN A BINARY SEARCH TREE

  public int findMax(TreeNode root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int result = root.data;
    int left = findMax(root.left);
    int right = findMax(root.right);

    if (left > right) {
      result = left;
    }
    if (right > left) {
      result = right;
    }

    return result;
  }

  static BsTreeNode insertingNodeInBinarySearchTree(BsTreeNode root, int value) {

    if (root == null) {
      root = new BsTreeNode(value);
      return root;
    }

    if (value < root.data) {
      root.left = insertingNodeInBinarySearchTree(root.left, value);
    } else {
      root.right = insertingNodeInBinarySearchTree(root.right, value);
    }
    return root;
  }

  public void insert(int value) {
    bstRoot = insertingNodeInBinarySearchTree(bstRoot, value);
  }

  public BsTreeNode searchforKeyinBinaryTree(BsTreeNode root, int key) {
    if (root == null || root.data == key) {
      return root;
    }

    if (key < root.data) {
      return searchforKeyinBinaryTree(root.left, key);
    } else {
      return searchforKeyinBinaryTree(root.right, key);
    }

  }

  public boolean checkingValidityOfBsTree(BsTreeNode root, int min, int max) {
    // { -min, +max}

    // the left side dont exceed above the root value and therefore have the same
    // minimum wc is infinity

    // the right side dont go below the root value and therefore have the same
    // maximum wc is infinity

    // if you go towards the left subtree min remains te same and max changes to
    // the parent value

    // if you go towards the right subtree max remains te same and min changes to
    // the parent value

    if (root == null) {
      return true;
    }
    if (root.data <= min || root.data >= max) { // checking -min <= root.data <= +max
      return false;
    }
    boolean left = checkingValidityOfBsTree(root.left, min, root.data);
    if (left) {
      boolean right = checkingValidityOfBsTree(root.right, root.data, max);
      return right;
    }
    return false;
  }

  void searchInaRowAndColumnWiseSortedMatrix(int[][] matrix, int rowsandcolumns, int searchvalue) {
    int i = 0;
    int j = rowsandcolumns - 1;

    while (i < rowsandcolumns && j >= 0) {
      if (matrix[i][j] == searchvalue) {
        System.out.println(" Number found at row: " + i + " and column " + j);
        return;
      }
      if (matrix[i][j] > searchvalue) {
        j--;
      }
      if (matrix[i][j] < searchvalue) {
        i++;
      }
    }
    System.out.println("value not found");
  }

  void printMatrixInSpiralForm(int[][] matrix, int r, int c) {

    // r = 4 k = 0
    // c = 4 l = 0

    int i, k = 0, l = 0;

    while (k < r && l < c) {
      for (i = l; i < c; i++) { // left -> right
        System.out.print(matrix[k][i] + " ");
      }
      k++;

      for (i = k; i < r; i++) { // top -> bottom
        System.out.print(matrix[i][c - 1] + " ");
      }
      c--;

      if (k < r) {
        for (i = c - 1; i >= l; i--) { // right -> left
          System.out.print(matrix[r - 1][i] + " ");
        }
        r--;

      }

      if (l < c) {
        for (i = r - 1; i >= k; i--) { // bottom -> top
          System.out.print(matrix[i][l] + " ");
        }
        l++;
      }

    }

  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();

    // bt.createBinaryTree();

    /*
     * // Pre-order traversal
     * System.out.println("Pre-order Traversal of Binary Tree:");
     * bt.recursivePreOrderTraversal(bt.root); // Display the tree using pre-order
     * traversal
     * 
     * // In-order traversal
     * System.out.println("\nIn-order Traversal of Binary Tree:");
     * bt.recursiveInOrderTraversal(bt.root); // Display the tree using pre-order
     * traversal
     * 
     * // Post-order traversal
     * System.out.println("\nPost-order Traversal of Binary Tree:");
     * bt.recursivePostOrderTraversal(bt.root); // Display using post-order
     * traversal
     * 
     * // Level-order traversal
     * System.out.println("\nLevel-order Traversal of Binary Tree:");
     * bt.levelOrderTraversal(bt.root); // Display using level-order traversal
     * 
     */

    /*
     * // iterative PreOrder Traversal BinaryTree
     * System.out.println("\nIterative PreOrder Traversal of Binary Tree:");
     * bt.iterativePreOrderTraversalofBinaryTree(bt.root); // Display using
     * level-order traversal
     * 
     * // Post-order traversal
     * System.out.println("\nRecursive Post-order Traversal of Binary Tree:");
     * bt.recursivePostOrderTraversal(bt.root); // Display using post-order
     * traversal
     * 
     * System.out.println("\nIterative Post-order Traversal of Binary Tree:");
     * bt.iterativePostOrderTraversalofBinaryTree(bt.root); // Display using
     * post-order traversal
     */

    /*
     * // finding max value in a binary tree
     * System.out.println(bt.findMax(bt.root));
     */

    /*
     * // search for a key in a binary search tree
     * 
     * bt.insert(1);
     * bt.insert(2);
     * bt.insert(3);
     * bt.insert(4);
     * bt.insert(5);
     * 
     * if (bt.searchforKeyinBinaryTree(bstRoot, 56) != null) {
     * System.out.println(" key found");
     * } else {
     * System.out.println("key not found");
     * }
     * 
     * Integer min = Integer.MIN_VALUE;
     * Integer max = Integer.MAX_VALUE;
     * 
     * if (bt.checkingValidityOfBsTree(bstRoot, min, max)) {
     * System.out.println("valid bst ");
     * } else {
     * 
     * System.out.println("invalid bst ");
     * }
     * 
     */

    int[][] matrix = {
        { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 51 }
    };

    bt.searchInaRowAndColumnWiseSortedMatrix(matrix, 4, 35);

    bt.printMatrixInSpiralForm(matrix, 4, 4);

  }

}
