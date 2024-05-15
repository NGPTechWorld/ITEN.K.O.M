package Controller;

import java.io.File;
import java.io.IOException;

import Module.Node;

public class DataBase {
    public static Node rootRectangle;
    public static String TextRectangle;
    public static File outputFile,inputFile;
    public DataBase() throws IOException{
        rootRectangle=new Node();
        TextRectangle="";
        outputFile=new File("output.txt");
        if(outputFile.exists())outputFile.delete();
        Boolean f1=outputFile.createNewFile();
        inputFile=new File("input.txt");
        if(inputFile.exists())inputFile.delete();
        Boolean f2=inputFile.createNewFile();
    }
    public static void resetDataBase()throws IOException{
        rootRectangle=new Node();
        TextRectangle="";
        if(outputFile.exists())outputFile.delete();
        Boolean f1=outputFile.createNewFile();
        inputFile=new File("input.txt");
        if(inputFile.exists())inputFile.delete();
        Boolean f2=inputFile.createNewFile();
    }
}
