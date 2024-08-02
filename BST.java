// Node class representing each node in the BST
class Node {
    int data; // The value stored in the node
    Node left; // Reference to the left child
    Node right; // Reference to the right child

    // Constructor to create a new node with the given data
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Binary Search Tree (BST) class
class BST {
    private Node root; // Root node of the BST

    // Constructor to initialize an empty BST
    public BST() {
        root = null;
    }

    // Method to insert a new node with the given data
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Helper method to insert a new node recursively
    private Node insertRec(Node root, int data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recursively traverse the tree to find the correct position
        if (data < root.data)
            root.left = insertRec(root.left, data); // Insert in the left subtree
        else if (data > root.data)
            root.right = insertRec(root.right, data); // Insert in the right subtree

        return root;
    }

    // Method to delete a node with the given data
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    // Helper method to delete a node recursively
    private Node deleteRec(Node root, int data) {
        // If the tree is empty, return null
        if (root == null) return root;

        // Traverse the tree to find the node to be deleted
        if (data < root.data)
            root.left = deleteRec(root.left, data); // Node to be deleted is in the left subtree
        else if (data > root.data)
            root.right = deleteRec(root.right, data); // Node to be deleted is in the right subtree
        else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Helper method to find the minimum value in a subtree
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Method to search for a node with the given data
    public boolean search(int data) {
        return searchRec(root, data);
    }

    // Helper method to search for a node recursively
    private boolean searchRec(Node root, int data) {
        // Base case: root is null or data is present at root
        if (root == null) return false;
        if (root.data == data) return true;

        // Data is greater than root's data
        if (data < root.data)
            return searchRec(root.left, data); // Search in the left subtree
        else
            return searchRec(root.right, data); // Search in the right subtree
    }

    // Method for in-order traversal of the BST
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    // Helper method for in-order traversal recursively
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Method for pre-order traversal of the BST
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    // Helper method for pre-order traversal recursively
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Method for post-order traversal of the BST
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    // Helper method for post-order traversal recursively
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        // Create a new Binary Search Tree (BST)
        BST bst = new BST();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Perform in-order traversal
        System.out.println("In-order traversal:");
        bst.inorder();

        // Perform pre-order traversal
        System.out.println("Pre-order traversal:");
        bst.preorder();

        // Perform post-order traversal
        System.out.println("Post-order traversal:");
        bst.postorder();

        // Search for a node
        int searchValue = 40;
        System.out.println("Searching for " + searchValue + ": " + (bst.search(searchValue) ? "Found" : "Not Found"));

        // Delete a node
        int deleteValue = 20;
        System.out.println("Deleting " + deleteValue);
        bst.delete(deleteValue);

        // Perform in-order traversal after deletion
        System.out.println("In-order traversal after deletion:");
        bst.inorder();
    }
}