package Controller;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Module.Node;

public class RectangleFormatController {
    public static String[] rectangle;
    public static char[][] rec;
    public static Node root;
    static int sizeW=1,sizeH=1;

    //----------Import----------------------
    public static void Import(String[] c,Node root){
        rectangle = c;
        root = build(0,0,c.length - 1 , c[0].length() - 1);
    }
    static Node build(int x1,int y1,int x2,int y2){
        Node node = new Node();
        for(int i=x1+1;i<x2;i++){
            boolean tmp = true;
        for (int j=y1+1;j<y2;j++){
            if(rectangle[i].charAt(j)!='-'){
            tmp = false;
            break;
            }
        }
        if(tmp){
            node.value = String.valueOf('-');
            node.width = (y2 - y1 - 1);
            node.rightChild = build(i,y1,x2,y2);
            node.leftChild = build(x1,y1,i,y2);
            node.height = node.rightChild.height + node.leftChild.height + 1;
            return node;
        }
        }
        for(int j=y1+1;j<y2;j++){
            boolean tmp = true;
            for (int i=x1+1;i<x2;i++){
                if(rectangle[i].charAt(j)!='|'){
                    tmp = false;
                    break;
                }
            }
            if(tmp){
                node.value = String.valueOf('|');
                node.height = (x2 - x1 - 1);
                node.rightChild = build(x1,j,x2,y2);
                node.leftChild = build(x1,y1,x2,j);
                node.width = node.rightChild.width + node.leftChild.width + 1;
                return node;
            }
        }
        node.value="";
        for(int i=x1+1;i<x2;i++){
            for (int j=y1+1;j<y2;j++){
                if(!Invalid(rectangle[i].charAt(j))){
                    node.value += rectangle[i].charAt(j);
                }
            }
        }
        node.height = (x2 - x1 - 1);
        node.width = (y2 - y1 - 1);
        return node;
    }
    //----------Export----------------------
    public static void Export(Node node){
        root=node;
        rec = new char[root.height + 2][root.width + 2];
        for(int i=0;i<=root.height+1;i++)
            for(int j=0;j<=root.width+1;j++)
                rec[i][j]=' ';
        for(int i=0;i<= root.height+1;i++)
            rec[i][0] = rec[i][root.width+1] = '|';
        for (int i=1; i<= root.width;i++)
            rec[0][i] = rec[root.height+1][i] = '-';
        buildRec(1,1,root);
    }
    
    static void buildRec(int x,int y,Node node){
        if(!node.value.equals("-") && !node.value.equals("|")){
            int in=0;
            for(int i=x;i<x+node.width;i++)
                for(int j=y;j<y+node.height && in<node.value.length();j++,in++) 
                    if(rec[i][j]==' ')
                        rec[i][j] = node.value.charAt(in);
            //print();
            return;
        }
        if(node.value.equals("|")){
            for(int i=x;i<x+node.height;i++)
                rec[i][y+node.leftChild.width] = '|';
            //print();
            buildRec(x,y,node.leftChild);
            buildRec(x,y+node.leftChild.width+1,node.rightChild);
        }
        else{
            for(int i=y;i<y+node.width;i++)
            rec[x+node.leftChild.height][i]='-';
            //print();
            buildRec(x,y,node.leftChild);
            buildRec(x+node.leftChild.height+1,y,node.rightChild);
        }
    }
    public static void print(){
        for(int i=0;i<=root.height+1;i++)
            {
        for(int j=0;j<= root.width+1;j++)
            System.out.print(rec[i][j]);
            System.out.println();
        }
    }
    static boolean Invalid(char x) {
        return (x == '(' || x == ')' || x == '[' || x == ']' || (x >= '0' && x <= '9') || x == ',' || x == ' ');
    }
    public static void fillTextFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            // Write each character array to the file
            for (char[] row : rec) {
                for (char ch : row) {
                    writer.write(ch);
                }
                writer.newLine(); // Write a new line after each row
            }

            // Close the writer
            writer.close();
            System.out.println("Successfully wrote the character array to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

