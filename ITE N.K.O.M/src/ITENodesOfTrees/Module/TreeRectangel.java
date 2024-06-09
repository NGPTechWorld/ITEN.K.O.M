package ITENodesOfTrees.Module;

public class TreeRectangel {
    
    public static void rotate(Node root) {

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
    public static boolean checkMergeTwoNodes(Node leftChild, Node rightChild) {
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

    public static boolean checkMerge(Node root) {
        // to check leaf
        if (root.rightChild == null || root.leftChild == null) {
            return true;
        }
        // Check merge leftChild with rightChild
        if(root.width ==0 || root.height ==0)
            return false;
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
