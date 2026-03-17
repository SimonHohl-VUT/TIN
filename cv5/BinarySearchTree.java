package cv5;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = insertRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = insertRecursive(current.right, data);
        }

        return current;
    }

    public void printTree() {
        System.out.print("BST (in-order): ");
        printInOrder(root);
        System.out.println();

        System.out.print("BST (pre-order): ");
        printPreOrder(root);
        System.out.println();

        System.out.print("BST (post-order): ");
        printPostOrder(root);
        System.out.println();

        System.out.print("BST (reverse in-order): ");
        printReverseInOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printPostOrder(Node node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    private void printReverseInOrder(Node node) {
        if (node == null) {
            return;
        }
        printReverseInOrder(node.right);
        System.out.print(node.data + " ");
        printReverseInOrder(node.left);
    }

    public void printTreeStructure() {
        System.out.println("BST (structure):");
        printTreeStructure(root, "", true);
    }

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.data) {
            return true;
        }
        return value < node.data
            ? containsRecursive(node.left, value)
            : containsRecursive(node.right, value);
    }

    public long searchWithTime(int value) {
        long start = System.nanoTime();
        boolean found = contains(value);
        long duration = System.nanoTime() - start;
        System.out.println("Search " + value + " -> " + (found ? "FOUND" : "NOT FOUND") + " (" + duration + " ns)");
        return duration;
    }

    private void printTreeStructure(Node node, String prefix, boolean isTail) {
        if (node == null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + "null");
            return;
        }

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data);

        if (node.left != null || node.right != null) {
            String childPrefix = prefix + (isTail ? "    " : "│   ");
            printTreeStructure(node.left, childPrefix, node.right == null);
            printTreeStructure(node.right, childPrefix, true);
        }
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    
    public Node getRoot() {
        return root;
    }

    public int printTreeLeaves() {
        System.out.print("Leaf nodes: ");
        int maxDepth = printTreeLeaves(root, 1);
        System.out.println();
        return maxDepth;
    }

    private int printTreeLeaves(Node node, int depth) {
        if (node == null) {
            return depth - 1;
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return depth;
        }

        int leftMax = printTreeLeaves(node.left, depth + 1);
        int rightMax = printTreeLeaves(node.right, depth + 1);
        return Math.max(leftMax, rightMax);
    }
} 
