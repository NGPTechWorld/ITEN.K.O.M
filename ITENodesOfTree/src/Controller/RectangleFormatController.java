package Controller;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Module.Node;

public class RectangleFormatController {
    public static char rectangel[][]=new char[100][100];
    static int maxW=0;
    public static void drawRec(Node node,int inW,int inH){
        int w=node.width;
        int h=node.height;
        int i =0;
        for (i= 1; i < w; i++) {
            if(rectangel[inH][i+inW]==' ')
            rectangel[inH][i+inW]='-';
            if(rectangel[inH+h-1][i+inW]==' ')
            rectangel[inH+h-1][i+inW]='-';
        }
        System.out.println("I valu= "+(i-1));
        int m=0;
        for ( m= 0; m < h; m++) {
            if(rectangel[m+inH][inW]==' ')
            rectangel[m+inH][inW]='|';
            if(rectangel[m+inH][inW+w]==' ')
            rectangel[m+inH][inW+w]='|';
            // for (int j = 1; j <w+1 ; j++) {
            //     rectangel[i+inH][j+inW]=' ';
            // }
        }
        System.out.println("I valu= "+(i-1)+"  H valu= "+(m));
        for (int k = 0; k < 100; k++) {
            for (int j = 0; j < 100;j++) {
                System.out.print(rectangel[k][j]);
            }
            System.out.println();
        }
        System.out.println("================");
        if (maxW<inW+w) {
            maxW=inW+w;
        }
        return;
    }
    static int W=0,H=0;
    public static void export(Node node,Node father){
        if(node==null)return;
        export(node.leftChild,node);
        int w=node.width;
        int h=node.height;
        System.out.println("W="+w+" H="+h +node.value);
        System.out.println(W+" | "+H);
        if(node.leftChild==null&& node.rightChild==null){
            drawRec(node,W,H);
            //System.out.println(father.value);
        }
        export(node.rightChild,node);
        if(father!=null)
        if(father.value=="|"){
            W+=w;
        }else if(father.value=="-"){
            H+=(h-1);W=maxW-w;
            System.out.println("HHHHHHHHHHH");
        }
    }
    // public static void drawRec(int width,int height){
    //     PrintWriter writer = null;
    //     try {
    //         writer = new PrintWriter("empty_rectangle.txt");
    //         // رسم الحدود العلوية
    //         for (int i = 0; i < width; i++) {
    //             writer.print("-");
    //         }
    //         writer.println();
    //         // رسم الجدران الجانبية
    //         for (int i = 2; i < height; i++) {
    //             writer.print("|");
    //             for (int j = 2; j < width; j++) {
    //                 writer.print(" ");
    //             }
    //             writer.println("|");
    //         }

    //         // رسم الحدود السفلية
    //         for (int i = 0; i < width; i++) {
    //             writer.print("-");
    //         }
    //         writer.println();
    //     } catch (FileNotFoundException e) {
    //         e.printStackTrace();
    //     } finally {
    //         if (writer != null) {
    //             writer.close(); // إغلاق الملف بعد الانتهاء
    //         }
    //     }

    // }
    // public static void drawRectangle(char[][] matrix, int startRow, int startCol, int height, int width, char symbol) {
    //     for (int i = startRow; i < startRow + height; i++) {
    //         for (int j = startCol; j < startCol + width; j++) {
    //             // التحقق من أن الصف والعمود داخل حدود المصفوفة
    //             if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
    //                 matrix[i][j] = symbol;
    //             }
    //         }
    //     }
    // }

    // // طباعة المصفوفة المحارفية في ملف نصي
    // public static void printMatrixToFile(char[][] matrix, String fileName) {
    //     PrintWriter writer = null;

    //     try {
    //         writer = new PrintWriter(fileName);

    //         // طباعة المصفوفة المحارفية
    //         for (int i = 0; i < matrix.length; i++) {
    //             for (int j = 0; j < matrix[0].length; j++) {
    //                 writer.print(matrix[i][j]);
    //             }
    //             writer.println();
    //         }
    //     } catch (FileNotFoundException e) {
    //         e.printStackTrace();
    //     } finally {
    //         if (writer != null) {
    //             writer.close(); // إغلاق الملف بعد الانتهاء
    //         }
    //     }
    // }
}
