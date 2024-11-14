package Left_off_11_8;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        BST theTree = new BST();
        theTree.addNode(50, "The Boss");
        theTree.addNode(45, "VP of Operations");
        theTree.addNode(55, "VP of Development");
        theTree.addNode(40, "Operations Manager");
        theTree.addNode(58, "Development Manager");
        theTree.addNode(60, "Development Worker");
        inOderTraversal( theTree.getRoot() );

        System.out.printf("\n Tree Height:%s", theTree.getTreeHeight( theTree.getRoot() ));

        BSTNode foundNode = theTree.findNode( 60 );
        if ( foundNode != null ) {
            System.out.printf("\n Found Node:%s", foundNode.key);
        } else {
            System.out.printf("\n Node not found");
        }
        System.out.printf("\n --------------------------");
        System.out.printf("\n The sum of tree is:%s", sumBST( theTree.getRoot() ));
        System.out.printf("\n --------------------------");
        System.out.printf("\n The sum of tree is:%s", getTreeHeight(theTree.getRoot()));

    }



    private static void inOderTraversal(BSTNode focusNode ) {
        if ( focusNode != null ) {
            inOderTraversal( focusNode.leftChild);
            System.out.printf("\n Key:%s", focusNode.key);
            inOderTraversal( focusNode.rightChild);
        }
    }
    static int sumBST( BSTNode root ) {
        int sum = 0;
        Queue<BSTNode> myQ = new LinkedList<>();
        myQ.add(root);
        while (!myQ.isEmpty()) {
            BSTNode curr = myQ.poll(); // Removes first item
            sum += curr.key;
            if (curr.leftChild != null) {
                myQ.add(curr.leftChild);
            }
            if (curr.rightChild != null) {
                myQ.add(curr.rightChild);
            }
        }
        return sum;
    }
    public static int getTreeHeight(BSTNode root) {
        if (root == null) {
            return -1;
        }
        Queue<BSTNode> myQ = new LinkedList<>();
        int height = -1;
        myQ.add(root);
        while (!myQ.isEmpty()) {
            int levelSize = myQ.size();
            for( int i = 0; i < levelSize; i++ ) {
                BSTNode curr = myQ.poll();
                if (curr.leftChild != null) {
                    myQ.add(curr.leftChild);
                }
                if (curr.rightChild != null) {
                    myQ.add(curr.rightChild);
                }
            }
            height++;
        }
        return height;
    }
}