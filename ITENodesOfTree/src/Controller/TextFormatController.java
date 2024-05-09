package Controller;

import Module.Node;
import Module.TreeRectangel;

public class TextFormatController {
    //---Export---
    static public String export(Node node){
        if(node == null)
            return "";
        String string=node.getValue();
        if (!(string =="|" ||string =="-" )){
            string=node.getValue()+"["+node.width+","+node.height+"]";
        }
        return "("+export(node.getLeftChild())+string+export(node.getRightChild())+")";
        
    }
    //---Import---
    private static int[] sum;
    private static String tree;
    public static Node root;
    final static int INF = 10000;

    public static void Import(String s) {
        tree = s;
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

    private static int Min(int left, int right) {
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

    private static Node build(int left, int right) {
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

    private static boolean Invalid(char x) {
        return (x == '(' || x == ')' || x == '[' || x == ']' || (x >= '0' && x <= '9') || x == ',' || x == ' ');
    }
}
