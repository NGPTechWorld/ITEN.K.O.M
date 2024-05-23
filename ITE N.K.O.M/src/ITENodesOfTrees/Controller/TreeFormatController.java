package ITENodesOfTrees.Controller;

import ITENodesOfTrees.Module.Node;
import ITENodesOfTrees.View.TreeFormatUI;

public class TreeFormatController {
    static int ch=0;
    public static Node treeRoot;
    public static void addNodeToTree(String name,int height,int width){
        Node newNode=new Node(name, width, height);
        if(treeRoot==null){
            System.out.println("Root");
            treeRoot=newNode;
        }else{
            ch=0;
            find(treeRoot,null,name);
        }
        TreeFormatUI.bt.updateTree(treeRoot);
        Node.dfs(treeRoot);
    }
    public static Node searchNode(Node root,Node father){
        if(root==null){
            return root;
        }else{
            if(father!=null){
                System.out.println("H");
                searchNode(root.leftChild,root);
                if(!(root.value.equals("|")&&root.value.equals("-")&&root.value.equals("-")))
                    searchNode(root.rightChild,root);
                }
            }
            return null; 
    }
    
    static void find(Node root,Node father,String v){
        // if(father!=null)
        // if(!(father.value.equals("|")&&father.value.equals("-")&&father.value.equals("-"))){
        //     return;
        // }
        if(ch==1)return;
        if(!(root.value.equals("|")||root.value.equals("-")||root.value.equals("-"))){
           return;
        }
        if(root.leftChild==null){
            root.leftChild=new Node(v);
            ch=1;
            return;
        }
        find(root.leftChild, root, v);
        if(ch==0){
            if(root.rightChild==null){
                root.rightChild=new Node(v);
                ch=1;
                return;
            }
            find(root.rightChild, root, v);
        }
    }
   public static boolean isEndTree(Node node){
        
            if(node.leftChild==null &&node.rightChild==null)
                if(!(node.value.equals("|")||node.value.equals("-")||node.value.equals("-")))
                    return true;
            else{
                return false;
            }
        return isEndTree(node.leftChild) && isEndTree(node.rightChild);
    }
}
