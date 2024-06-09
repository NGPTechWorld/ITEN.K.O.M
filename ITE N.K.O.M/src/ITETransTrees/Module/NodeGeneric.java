package ITETransTrees.Module;

import java.util.ArrayList;
import java.util.List;

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
}
