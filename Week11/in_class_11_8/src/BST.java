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

    }
