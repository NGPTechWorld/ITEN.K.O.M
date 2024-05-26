package ITETransTrees.Controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import ControllersUI.DataBase;
import ITETransTrees.Module.*;

public class GenericTreeController {

    
    
    public static HashMap<String, String[]> frequency = new HashMap<>();

    public static void Export() {
        if (DataBase.G_root == null)
            return;
        GetEdges();
    }

    private static void GetEdges() {
        DataBase.genericEdges.clear();
        GetEdges(DataBase.G_root);
    }

    private static void GetEdges(NodeGeneric node) {
        if (node.child.isEmpty())
            return;
        String edge = node.value;
        edge += " -> ";
        for (NodeGeneric n : node.child) {
            edge += n.value + ",";
        }
        DataBase.genericEdges.add(edge.substring(0, edge.length() - 1));
        for (NodeGeneric n : node.child) {
            GetEdges(n);
        }
    }

    public static void Import(String[] s) {

        HashMap<String, Boolean> Root = new HashMap<>();
        for (String str : s) {
            String name = "";
            int i;
            for (i = 0; i < str.length() && str.charAt(i) != '>'; i++) {
                if (str.charAt(i) == ' ' || str.charAt(i) == '-')
                    continue;
                name += str.charAt(i);
            }
            while (str.charAt(i) == '>' || str.charAt(i) == ' ')
                i++;
            if (!Root.containsKey(name))
                Root.put(name, true);
            String children = "";
            for (;i<str.length();i++)
                if(str.charAt(i)!=' ')
                    children += str.charAt(i);
            frequency.put(name, children.split(","));
            String[] edge = frequency.get(name);
            for (String e : edge) {
                Root.put(e, false);
            }
        }
        for (Map.Entry h : Root.entrySet()) {
            if ((boolean) h.getValue()) {
                DataBase.G_root = build((String) h.getKey());
                break;
            }
        }
    }

    private static  NodeGeneric build(String name) {
        NodeGeneric node = new NodeGeneric();
        node.value = name;
        if (frequency.containsKey(name)) {
            for (String s : frequency.get(name)) {
                node.child.add(build(s));
            }
        }
        return node;
    }

    public static void dfs(NodeGeneric node, NodeGeneric p) {
        if (node == null)
            return;
        System.out.println(p.value + " -> " + node.value);
        for (NodeGeneric c : node.child) {
            dfs(c, node);
        }
    }

    public static void convertGtoB(NodeGeneric root) {
        DataBase.B_root = transformGenericToBinary(root, root.child.size() - 1, null);
    }

    public static  NodeGeneric transformGenericToBinary(NodeGeneric node, int index, NodeGeneric parent) {
        if (node == null)
            return null;
            NodeGeneric new_node = new NodeGeneric();
        new_node.value = node.value;
        if (index == 0 || parent == null)
            new_node.child.add(transformGenericToBinary(null, 0, null));
        else
            new_node.child.add(
                    transformGenericToBinary(parent.child.get(index - 1), index - 1, parent)
            );
        if (!node.child.isEmpty())
            new_node.child.add(
                    transformGenericToBinary(node.child.get(node.child.size() - 1), node.child.size() - 1, node)
            );
        else
            new_node.child.add(transformGenericToBinary(null, 0, null));
        return new_node;
    }

    public static void convertBtoG(NodeGeneric root) {
        DataBase.G_root = transformBinaryToGeneric(root);
    }

    public static  NodeGeneric transformBinaryToGeneric(NodeGeneric node) {
        if (node == null)
            return null;
            NodeGeneric new_node = new NodeGeneric();
        new_node.value = node.value;
        if (node.child.get(1) != null) {
            List<NodeGeneric> child = new ArrayList<>();
            getChildrenOfNode(node.child.get(1), child);
            for (NodeGeneric c : child) {
                new_node.child.add(transformBinaryToGeneric(c));
            }
        }
        return new_node;
    }

    private static  void getChildrenOfNode(NodeGeneric node, List<NodeGeneric> parent) {
        if (node == null)
            return;
        getChildrenOfNode(node.child.get(0), parent);
        parent.add(node);
    }

    public static String[] readFileToStringArray() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DataBase.inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.toArray(new String[0]);
    }

    public static void fillTextFile() {
        try {
            FileWriter fileOutput = new FileWriter(DataBase.outputFile);
            BufferedWriter writer = new BufferedWriter(fileOutput);
            for (String row : DataBase.genericEdges) {
                    writer.write(row);
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
