package ITETransTrees.Module;

import java.util.ArrayList;
import java.util.List;

import ITENodesOfTrees.Module.Node;

public class NodeGeneric {
    
    public List<NodeGeneric> child = new ArrayList<>();
    public String value;
    public NodeGeneric(String string) {
        value=string;
        child=new ArrayList<>();
    }
    public NodeGeneric(){
        child=new ArrayList<>();
    }
    public static  Node convert(NodeGeneric b_root) {
        if (b_root == null)
            return null;
        Node node = new Node();
        node.value = b_root.value;
        node.leftChild = convert(b_root.child.get(0));
        node.rightChild = convert(b_root.child.get(1));
        return node;
    }

}
