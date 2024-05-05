package Controller;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RectangleFormatController {

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
