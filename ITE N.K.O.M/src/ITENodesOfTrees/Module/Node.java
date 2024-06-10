package ITENodesOfTrees.Module;

public class Node {
    public String value;
    public Node leftChild;
    public Node rightChild;
    public int width, height;

    public Node() {
    }

    public Node(String value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
        this.height = 0;
        this.width = 0;
    }

    public Node(String value, int width, int height) {
        this.value = value;
        leftChild = null;
        rightChild = null;
        this.height = height;
        this.width = width;
    }

    public String getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    public static void dfs(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        System.out.println(node.height);
        dfs(node.leftChild);
        dfs(node.rightChild);
    }
}
