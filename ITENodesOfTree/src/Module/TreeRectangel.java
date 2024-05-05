package Module;

public class TreeRectangel {
    public Node root;

    public TreeRectangel() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void addNode(String value,int width,int height) {
        root = addNodeRecursive(root, value, width, height);
    }

    private Node addNodeRecursive(Node current, String value,int width,int height) {
        if (current == null) {
            return new Node(value, width, height);
        }

        if (current.width==1) {
            current.setLeftChild(addNodeRecursive(current.getLeftChild(), value, width, height));
        } else if (current.width==0) {
            current.setRightChild(addNodeRecursive(current.getRightChild(), value, width, height));
        }

        return current;
    }
}
