package View.ITENodesOfTress;
import java.io.IOException;

import Controller.*;
import Module.Node;
import View.*;
public class ITENodsOfTree {
    public static void dfs(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        dfs(node.leftChild);
        dfs(node.rightChild);
    }
    public static void main(String[] args) throws IOException {
        // String s="";
        // TextFormatController.Import("(A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))\r");
        // //System.out.println(TextFormatController.root.value);
        // dfs(TextFormatController.root);
        // RectangleFormatController.Export(TextFormatController.root);
        // System.out.println();
        // RectangleFormatController.print();
        // RectangleFormatController.fillTextFile();
        // RectangleFormatController.Export(TextFormatController.root);
        // System.out.println(TextFormatController.export(TextFormatController.root));
        new DataBase();
        new HomePage();
        //new addNodeTree(TextFormatController.root);
        // Node root=new Node("-",70,60);
        // root.leftChild=new Node("|",70,10);
        // root.leftChild.leftChild=new Node("A",20,10);
        // root.leftChild.rightChild=new Node("|",50,10);
        // root.leftChild.rightChild.leftChild=new Node("B",20,10);
        // root.leftChild.rightChild.rightChild=new Node("C",30,10);
        // root.rightChild=new Node("|",70,50);
        // root.rightChild.leftChild=new Node("D",30,50);
        // root.rightChild.rightChild=new Node("-",40,50);
        // root.rightChild.rightChild.leftChild=new Node("E",40,30);
        // root.rightChild.rightChild.rightChild=new Node("F",40,20);
        // RectangleFormatController.Export(root);
        // for (int i = 0; i < 100; i++) {
        //     for (int j = 0; j < 100;j++) {
        //         RectangleFormatController.rectangel[i][j]=' ';
        //     }
        //     System.out.println();
        // }RectangleFormatController.rectangel[68][69]='Z';
        // RectangleFormatController.rectangel[69][69]='Z';
        // RectangleFormatController.export(root,null);
        // for (int i = 0; i < 100; i++) {
        //     for (int j = 0; j < 100;j++) {
        //         System.out.print(RectangleFormatController.rectangel[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println(RectangleFormatController.rectangel[0][13]);
    }
}