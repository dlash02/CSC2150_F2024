package Left_off_11_8;

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
    public int getTreeHeight( BSTNode focusNode ) {
        if ( focusNode == null ) {
            return -1;
        }
        int leftHeight = getTreeHeight( focusNode.leftChild );
        int rightHeight = getTreeHeight( focusNode.rightChild );
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public BSTNode getRoot() {
        return root;
    }
   public  BSTNode findNode( int key ) {
        // return null if key not found else return the node
        BSTNode focusNode = root;
        while ( focusNode.key !=  key ) {
            if ( key < focusNode.key ) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if ( focusNode == null ) {
                return null;
            }
        }
        return focusNode;
    }
}
