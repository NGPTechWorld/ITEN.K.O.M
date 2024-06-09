package ITETransTrees.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ControllersUI.DataBase;
import ITETransTrees.Module.NodeGeneric;

public class BinaryTreeController {
    public static HashMap<String, String[]> frequency = new HashMap<>();
    public static List<String> BinaryToText(NodeGeneric b_root) {
        List<String> result = new ArrayList<>();
        GetBinaryEdges(b_root, result);
        return result;
    }
    
    public static void GetBinaryEdges(NodeGeneric node, List<String> Edges) {
        if (node == null)
            return;
        if (node.child.get(0) == null && node.child.get(1) == null)
            return;
        String edge = node.value + " -> ";
        if (node.child.get(0) != null)
            edge += node.child.get(0).value;
        edge += ",";
        if (node.child.get(1) != null)
            edge += node.child.get(1).value;
        Edges.add(edge);
        GetBinaryEdges(node.child.get(0), Edges);
        GetBinaryEdges(node.child.get(1), Edges);
    }

    public static void TextToBinary(List<String> s) {
        frequency.clear();
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
            for (; i < str.length(); i++)
                if (str.charAt(i) != ' ')
                    children += str.charAt(i);
            frequency.put(name, children.split(","));
            String[] edge = frequency.get(name);
            for (String e : edge) {
                if (e.isEmpty())
                    continue;
                Root.put(e, false);
            }
        }
        for (Map.Entry h : Root.entrySet()) {
            if ((boolean) h.getValue()) {
                DataBase.B_root = BinaryBuild((String) h.getKey());
                break;
            }
        }
    }

    public static NodeGeneric BinaryBuild(String key) {
        if (key.isEmpty())
            return null;
        NodeGeneric node = new NodeGeneric();
        node.value = key;
        if (frequency.containsKey(key)) {
            if (frequency.get(key).length == 2) {
                node.child.add(BinaryBuild(frequency.get(key)[0]));
                node.child.add(BinaryBuild(frequency.get(key)[1]));
            } else {
                node.child.add(BinaryBuild(frequency.get(key)[0]));
                node.child.add(null);
            }
        }
        return node;
    }

    
    public static void convertBtoG(NodeGeneric root) {
        DataBase.G_root = transformBinaryToGeneric(root);
    }

    public static NodeGeneric transformBinaryToGeneric(NodeGeneric node) {
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
    private static void getChildrenOfNode(NodeGeneric node, List<NodeGeneric> parent) {
        if (node == null)
            return;
        getChildrenOfNode(node.child.get(0), parent);
        parent.add(node);
    }

}
