package Prep_W11;

import java.util.LinkedList;
import java.util.Queue;

public class BSTDriver {
    public static void main(String[] args) {
        BST theTree = new BST();
        theTree.addNode( 50, "The Boss");
        theTree.addNode( 25, "The VP");
        theTree.addNode( 15, "Office Manager" );
        theTree.addNode( 70, "Sales Manager" );
        theTree.addNode( 85, "SalesPerson" );
        theTree.addNode( 27, "Someone" );
        theTree.addNode( 88, "Someone Else" );
        int key = 27;
        BSTNode n = theTree.findNode(key);
        if ( n == null ){
            System.out.printf("\n Key not found");
        } else {
            System.out.printf("\n Key:%s found value=%s", key, n.name );
        }

        System.out.printf("\n-----> Tree Height:%s" , theTree.treeHeight(theTree.getRoot()));

        System.out.printf("\n-->> sum all keys%s", theTree.sumAllKeys(theTree.getRoot()));

        //inORderTravsTree( theTree.root );
        //
        // postORderTravsTree( theTree.root );
        preOrderTravsTree( theTree.getRoot() );
    }
    public static void inORderTravsTree( BSTNode focusNode ){
            // InOrder traversal -> Left -> Node -> Right
            // Recsurisiv-e?
            // The Escape Clause
            if ( focusNode != null){
                inORderTravsTree( focusNode.leftChild);
                System.out.printf( "\n%s", focusNode.key);
                inORderTravsTree( focusNode.rightChild);
            }
    }
    public static void postORderTravsTree( BSTNode focusNode ) {
        // PostOrder traversal -> Left ->  Right  -> Node
        // Recsurisiv-e?
        // The Escape Clause
        if ( focusNode != null){
            postORderTravsTree( focusNode.leftChild);
            postORderTravsTree( focusNode.rightChild);
            System.out.printf( "\n%s", focusNode.key);
        }
    }
    public static void preOrderTravsTree( BSTNode focusNode ) {
        if ( focusNode != null){
            System.out.printf( "\n%s", focusNode.key);
            preOrderTravsTree( focusNode.leftChild);
            preOrderTravsTree( focusNode.rightChild);
        }
    }
    public void byLevelTraversal(BSTNode root) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BSTNode currentNode = queue.poll();
            System.out.print(currentNode.key + " ");

            // Add left child to the queue
            if (currentNode.leftChild != null) {
                queue.add(currentNode.leftChild);
            }

            // Add right child to the queue
            if (currentNode.rightChild != null) {
                queue.add(currentNode.rightChild);
            }
        }
    }
}
