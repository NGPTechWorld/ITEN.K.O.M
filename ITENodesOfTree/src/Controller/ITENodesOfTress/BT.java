package Controller.ITENodesOfTress;

import Module.Node;

public class BT {
    int[] sum;
    String tree;
    public Node root;
    final static int INF = 10000;

    public void Import(String s) {
        this.tree = s;
        sum = new int[tree.length()];
        for (int i = 0; i < tree.length(); i++) {
            if (tree.charAt(i) == '(')
                sum[i]++;
            else if (tree.charAt(i) == ')')
                sum[i]--;
            if (i != 0)
                sum[i] += sum[i - 1];
        }
        for (int i = 0; i < tree.length(); i++) {
            if (Invalid(tree.charAt(i)))
                sum[i] = INF;
        }
        root = build(0, tree.length() - 1);
    }

    int Min(int left, int right) {
        int index = -1;
        for (int i = left; i <= right; i++) {
            if ((tree.charAt(i) == '|' || tree.charAt(i) == '–' || tree.charAt(i) == '-') && index == -1) {
                index = i;
            }
            if ((tree.charAt(i) == '|' || tree.charAt(i) == '–' || tree.charAt(i) == '-') && sum[index] > sum[i]) {
                index = i;
            }
        }

        if (index == -1)
            for (int i = left; i <= right; i++)
                if (sum[i] != INF) {
                    index = i;
                    break;
                }
        return index;
    }

    Node build(int left, int right) {
        int Index = Min(left, right);
        Node node = new Node();
        if (tree.charAt(Index) != '|' && tree.charAt(Index) != '–' && tree.charAt(Index) != '-') {
            int height = 0;
            int width = 0;
            node.value = "";
            for (; tree.charAt(Index) != '['; Index++)
                node.value += tree.charAt(Index);
            Index++;
            for (; tree.charAt(Index) != ','; Index++)
                width = width * 10 + tree.charAt(Index) - '0';
            Index++;
            for (; tree.charAt(Index) != ']'; Index++)
                height = height * 10 + tree.charAt(Index) - '0';
            node.width = width;
            node.height = height;
            return node;
        }
        node.value = String.valueOf(tree.charAt(Index));
        node.leftChild = build(left, Index - 1);
        node.rightChild = build(Index + 1, right);
        if (tree.charAt(Index) == '|') {
            node.width = node.leftChild.width + node.rightChild.width;
            node.height = node.rightChild.height;
        } else {
            node.height = node.leftChild.height + node.rightChild.height;
            node.width = node.rightChild.width;
        }
        return node;
    }

    public void dfs(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        dfs(node.leftChild);
        dfs(node.rightChild);
    }

    static boolean Invalid(char x) {
        return (x == '(' || x == ')' || x == '[' || x == ']' || (x >= '0' && x <= '9') || x == ',' || x == ' ');
    }

    // AlZero***********************************
    // rotate
    public void rotate() {
        rotate(root);
    }

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
    public void checkMerge() {
        checkMerge(root);
    } // just call it in main without passing parameter

    private void checkMerge(Node root) {
        // Tree is empty
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }

        // to check leaf
        if (root.rightChild == null && root.leftChild == null) {
            return;
        }

        // recursive //check all the tree
        checkMerge(root.leftChild);
        checkMerge(root.rightChild);

        // Check merge leftChild with rightChild
        if (root.value.equals("-") || root.value.equals("–")) {
            if (root.leftChild.width == root.rightChild.width) {
                System.out.println("you can merge " + root.leftChild.value + " and " + root.rightChild.value);
            } else {
                System.out.println("you can't merge " + root.leftChild.value + " and " + root.rightChild.value);
            }
        } else // "|"
        {
            if (root.leftChild.height == root.rightChild.height) {
                System.out.println("you can merge " + root.leftChild.value + " and " + root.rightChild.value);
            } else {
                System.out.println("you can't merge " + root.leftChild.value + " and " + root.rightChild.value);
            }
        }

    }
}
