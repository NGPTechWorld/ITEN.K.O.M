package ITENodesOfTrees.Controller;

import ITENodesOfTrees.Module.Node;

public class BT {

    // AlZero***********************************
    // rotate

    private void rotate(Node root) {

        if (root == null)
            return;

        if (root.value.equals("|")) {
            root.value = "-";
            int temp = 0;
            temp = root.width;
            root.width = root.height;
            root.height = temp;
        } else if (root.value.equals("-") || root.value.equals("–")) {
            root.value = "|";
            int temp = 0;
            temp = root.width;
            root.width = root.height;
            root.height = temp;
        } else {
            int temp = 0;
            temp = root.width;
            root.width = root.height;
            root.height = temp;
        }
        rotate(root.leftChild);
        rotate(root.rightChild);
    }

    // AlZero *********************************
    // check merge two Nodes
    public boolean checkMergeTwoNodes(Node leftChild, Node rightChild) {

        // check leaf
        if (rightChild == null || leftChild == null) {
            return false;
        }

        // Check merge leftChild with rightChild
        if (leftChild.width == rightChild.width) {
            // System.out.println("you can merge " + leftChild.value + " and " +
            // rightChild.value);
            return true;
        } else if (leftChild.height == rightChild.height) {
            // System.out.println("you can merge " + leftChild.value + " and " +
            // rightChild.value);
            return true;
        } else {
            // System.out.println("you can't merge " + leftChild.value + " and " +
            // rightChild.value);
            return false;
        }

    }

    // AlZero****************************************
    // to check merge all the tree
    /*
     * private void checkMerge(Node root) {
     * // Tree is empty
     * if (root == null) {
     * System.out.println("The tree is empty");
     * return;
     * }
     * 
     * // to check leaf
     * if (root.rightChild == null && root.leftChild == null) {
     * return;
     * }
     * 
     * // recursive //check all the tree
     * checkMerge(root.leftChild);
     * checkMerge(root.rightChild);
     * 
     * // Check merge leftChild with rightChild
     * if (root.value.equals("-") || root.value.equals("–")) {
     * if (root.leftChild.width == root.rightChild.width) {
     * System.out.println("you can merge " + root.leftChild.value + " and " +
     * root.rightChild.value);
     * } else {
     * System.out.println("you can't merge " + root.leftChild.value + " and " +
     * root.rightChild.value);
     * }
     * } else // "|"
     * {
     * if (root.leftChild.height == root.rightChild.height) {
     * System.out.println("you can merge " + root.leftChild.value + " and " +
     * root.rightChild.value);
     * } else {
     * System.out.println("you can't merge " + root.leftChild.value + " and " +
     * root.rightChild.value);
     * }
     * }
     * 
     * }
     */
    boolean checkMerge(Node root) {
        // to check leaf
        if (root.rightChild == null || root.leftChild == null) {
            return true;
        }
        // Check merge leftChild with rightChild
        if (root.value.equals("-") || root.value.equals("–")) {
            if (root.leftChild.width != root.rightChild.width)
                return false;
        } else {
            if (root.leftChild.height != root.rightChild.height)
                return false;
        }
        return (checkMerge(root.rightChild) & checkMerge(root.leftChild));
    }
}
