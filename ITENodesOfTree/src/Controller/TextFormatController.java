package Controller;

import Module.Node;
import Module.TreeRectangel;

public class TextFormatController {
    static public String export(Node node){
        if(node == null)
            return "";
        String string=node.getValue();
        if (!(string =="|" ||string =="-" )){
            string=node.getValue()+"["+node.width+","+node.height+"]";
        }
        return "("+export(node.getLeftChild())+string+export(node.getRightChild())+")";
        
    }
    
}
