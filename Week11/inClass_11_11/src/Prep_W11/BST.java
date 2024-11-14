package Prep_W11;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private BSTNode root;
    public BST() {
        root = null;
    };
    public void addNode(int key, String name) {
        BSTNode newNode = new BSTNode(key, name);
        if (root == null) {
            root = newNode;
        } else {
            // not the first node
            BSTNode focusNode = root;
            BSTNode parent;
            while (true) {
                parent = focusNode;
                if ( key < focusNode.key ){
                    // to the left
                    focusNode = focusNode.leftChild;
                    if ( focusNode == null ) {
                        // the we are at the end of the left
                        parent.leftChild = newNode;
                        break;
                    }
                } else {
                        focusNode = focusNode.rightChild;
                        if ( focusNode == null ){
                            parent.rightChild = newNode;
                            break;
                        }
                    }
                }
            }
        }

    public BSTNode getRoot() {
        return root;
    }
    public BSTNode findNode( int sKey ) {
        // Idea: Search BST and
        //    return the node if it finds it
        //    return  null if it does not find it
        // So we add nodes and then search by key
        BSTNode focusNode = root;
        while ( focusNode.key != sKey ) {
            if ( sKey < focusNode.key ) {
                // Search the left child
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if ( focusNode == null ){
                return null;
            }
        }
        return focusNode;
    }
    // Method to calculate the height of the tree
    public int treeHeight(BSTNode node) {
        if (node == null) {
            return -1; // Base case: empty subtree
        }
        int leftHeight = treeHeight(node.leftChild);
        int rightHeight = treeHeight(node.rightChild);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int getTreeHeight(BSTNode root) {
        if (root == null) {
            return -1; // Return -1 for an empty tree
        }
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        int height = -1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                BSTNode currentNode = queue.poll();

                // Add child nodes to the queue
                if (currentNode.leftChild != null) {
                    queue.add(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    queue.add(currentNode.rightChild);
                }
            }
            height++;
        }
        return height;
    }
    public int sumAllKeys(BSTNode node) {
        if (node == null) {
            return 0; // Base case: empty subtree contributes 0 to the sum
        }
        // Sum of current node's key + sum of left subtree + sum of right subtree
        return node.key + sumAllKeys(node.leftChild) + sumAllKeys(node.rightChild);
    }
}
