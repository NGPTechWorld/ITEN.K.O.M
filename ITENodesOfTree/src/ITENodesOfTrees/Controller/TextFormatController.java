package ITENodesOfTrees.Controller;

import ControllersUI.DataBase;
import ITENodesOfTrees.Module.Node;

public class TextFormatController {
    //---Export---
    static public  String export(Node node)
    {
        if(!node.value.equals("-") && !node.value.equals("|") && !node.value.equals("–")){
            return node.value + "[" + node.width + "," + node.height + "]";
        }
        return "(" + export(node.leftChild) + node.value + export(node.rightChild) + ")";
    }
    //---Import---
    private static int[] sum;
    final static int INF = 10000;

    public static void Import(String s) {
        DataBase.TextRectangle = s;
        sum = new int[DataBase.TextRectangle.length()];
        for (int i = 0; i < DataBase.TextRectangle.length(); i++) {
            if (DataBase.TextRectangle.charAt(i) == '(')
                sum[i]++;
            else if (DataBase.TextRectangle.charAt(i) == ')')
                sum[i]--;
            if (i != 0)
                sum[i] += sum[i - 1];
        }
        for (int i = 0; i < DataBase.TextRectangle.length(); i++) {
            if (Invalid(DataBase.TextRectangle.charAt(i)))
                sum[i] = INF;
        }
        DataBase.rootRectangle = build(0, DataBase.TextRectangle.length() - 1);
        System.out.println("Import Text Done!");
    }

    private static int Min(int left, int right) {
        int index = -1;
        for (int i = left; i <= right; i++) {
            if ((DataBase.TextRectangle.charAt(i) == '|' || DataBase.TextRectangle.charAt(i) == '–' || DataBase.TextRectangle.charAt(i) == '-') && index == -1) {
                index = i;
            }
            if ((DataBase.TextRectangle.charAt(i) == '|' || DataBase.TextRectangle.charAt(i) == '–' || DataBase.TextRectangle.charAt(i) == '-') && sum[index] > sum[i]) {
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
        if (DataBase.TextRectangle.charAt(Index) != '|' && DataBase.TextRectangle.charAt(Index) != '–' && DataBase.TextRectangle.charAt(Index) != '-') {
            int height = 0;
            int width = 0;
            node.value = "";
            for (; DataBase.TextRectangle.charAt(Index) != '['; Index++)
                node.value += DataBase.TextRectangle.charAt(Index);
            Index++;
            for (; DataBase.TextRectangle.charAt(Index) != ','; Index++)
                width = width * 10 + DataBase.TextRectangle.charAt(Index) - '0';
            Index++;
            for (; DataBase.TextRectangle.charAt(Index) != ']'; Index++)
                height = height * 10 + DataBase.TextRectangle.charAt(Index) - '0';
            node.width = width;
            node.height = height;
            return node;
        }
        node.value = String.valueOf(DataBase.TextRectangle.charAt(Index));
        node.leftChild = build(left, Index - 1);
        node.rightChild = build(Index + 1, right);
        if (DataBase.TextRectangle.charAt(Index) == '|') {
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
