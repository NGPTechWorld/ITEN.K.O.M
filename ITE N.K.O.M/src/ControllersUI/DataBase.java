package ControllersUI;

import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ITENodesOfTrees.Module.Node;
import ITETransTrees.Module.NodeGeneric;

public class DataBase {
    public static Node rootRectangle;
    public static String TextRectangle;
    public static File outputFile,inputFile;
    public static List<Node> Rectangles;
    public static List<String> genericEdges;
    public static NodeGeneric G_root, B_root;
    public DataBase() throws IOException{
        Rectangles=new ArrayList<>();
        genericEdges = new ArrayList<>();
        rootRectangle=new Node();
        TextRectangle="";
        outputFile=new File("output.txt");
        if(outputFile.exists())outputFile.delete();
        outputFile.createNewFile();
        inputFile=new File("input.txt");
        
        if(inputFile.exists())inputFile.delete();
        inputFile.createNewFile();
    }
    public static void resetDataBase()throws IOException{
        Rectangles=new ArrayList<>();
        genericEdges = new ArrayList<>();
        rootRectangle=new Node();
        TextRectangle="";
        if(outputFile.exists())outputFile.delete();
        outputFile.createNewFile();
        inputFile=new File("input.txt");
        if(inputFile.exists())inputFile.delete();
        inputFile.createNewFile();
    }
}
