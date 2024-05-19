package View.ITETransTrees;

import java.util.*;

import Module.Node;

public class Tree {
    NodeGeneric G_root, B_root;
    List<String> edges = new ArrayList<>();
    HashMap<String, String[]> frequency = new HashMap<>();

    void Import() {
        if (G_root == null)
            return;
        GetEdges();
    }

    private void GetEdges() {
        edges.clear();
        GetEdges(G_root);
    }

    private void GetEdges(NodeGeneric node) {
        if (node.child.isEmpty())
            return;
        String edge = node.value;
        edge += " -> ";
        for (NodeGeneric n : node.child) {
            edge += n.value + ",";
        }
        edges.add(edge.substring(0, edge.length() - 1));
        for (NodeGeneric n : node.child) {
            GetEdges(n);
        }
    }

    void Export(String[] s) {

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
                G_root = build((String) h.getKey());
                break;
            }
        }
    }

    private NodeGeneric build(String name) {
        NodeGeneric node = new NodeGeneric();
        node.value = name;
        if (frequency.containsKey(name)) {
            for (String s : frequency.get(name)) {
                node.child.add(build(s));
            }
        }
        return node;
    }

    void dfs(NodeGeneric node, NodeGeneric p) {
        if (node == null)
            return;
        System.out.println(p.value + " -> " + node.value);
        for (NodeGeneric c : node.child) {
            dfs(c, node);
        }
    }

    void ImportGtoB(NodeGeneric root) {
        B_root = transformGenericToBinary(root, root.child.size() - 1, null);
    }

    private NodeGeneric transformGenericToBinary(NodeGeneric node, int index, NodeGeneric parent) {
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

    void ExportBtoG(NodeGeneric root) {
        G_root = transformBinaryToGeneric(root);
    }

    private NodeGeneric transformBinaryToGeneric(NodeGeneric node) {
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

    private void getChildrenOfNode(NodeGeneric node, List<NodeGeneric> parent) {
        if (node == null)
            return;
        getChildrenOfNode(node.child.get(0), parent);
        parent.add(node);
    }
}
