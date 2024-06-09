package ControllersUI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ITENodesOfTrees.Module.Node;
import ITETransTrees.Module.NodeGeneric;

public class DataBase {
    //========= Q1 ============
    public static Node rootRectangle;
    public static String TextRectangle;
    public static File outputFile,inputFile;
    public static List<Node> Rectangles;
    //========= Q2 ============
    public static List<String> genericEdges;
    public static NodeGeneric G_root, B_root;

    public DataBase() throws IOException{
        G_root=new NodeGeneric();
        B_root=new NodeGeneric();
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
        G_root=new NodeGeneric();
        B_root=new NodeGeneric();
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
