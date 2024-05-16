package Controller;


import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import Module.Node;

public class RectangleFormatController {

    public static String[] rectangle;
    public static char[][] rec;
    //
    static int sizeW=1,sizeH=1;

    //----------Import----------------------
    public static void Import(String[] c){
        rectangle = c;
        DataBase.rootRectangle = build(0,0,c.length - 1 , c[0].length() - 1);
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

    public static String[] readFileToStringArray() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DataBase.inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.toArray(new String[0]);
    }
    //----------Export----------------------

    public static void Export(Node node){
        DataBase.rootRectangle=node;
        rec = new char[DataBase.rootRectangle.height + 2][DataBase.rootRectangle.width + 2];
        for(int i=0;i<=DataBase.rootRectangle.height+1;i++)
            for(int j=0;j<=DataBase.rootRectangle.width+1;j++)
                rec[i][j]=' ';
        for(int i=0;i<= DataBase.rootRectangle.height+1;i++)
            rec[i][0] = rec[i][DataBase.rootRectangle.width+1] = '|';
        for (int i=1; i<= DataBase.rootRectangle.width;i++)
            rec[0][i] = rec[DataBase.rootRectangle.height+1][i] = '-';
        buildRec(1,1,DataBase.rootRectangle);
        fillTextFile();
        System.out.println("Export Rectangle Done!");
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
        for(int i=0;i<=DataBase.rootRectangle.height+1;i++)
            {
        for(int j=0;j<= DataBase.rootRectangle.width+1;j++)
            System.out.print(rec[i][j]);
            System.out.println();
        }
    }
    static boolean Invalid(char x) {
        return (x == '(' || x == ')' || x == '[' || x == ']' || (x >= '0' && x <= '9') || x == ',' || x == ' ');
    }

    public static void fillTextFile(){
        try {
            FileWriter fileOutput=new FileWriter(DataBase.outputFile);
            BufferedWriter writer = new BufferedWriter(fileOutput);
            for (char[] row : rec) {
                for (char ch : row) {
                    writer.write(ch);
                }
                writer.newLine();
            }
            Desktop desktop = Desktop.getDesktop();
            desktop.edit(DataBase.outputFile);
            writer.close();
            System.out.println("Successfully wrote the character array to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

