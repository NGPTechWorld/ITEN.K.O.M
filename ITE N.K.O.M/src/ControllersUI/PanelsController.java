package ControllersUI;
import javax.swing.*;
import javax.swing.text.*;
import ITENodesOfTrees.ITENodsOfTreeMain;
import ITENodesOfTrees.Controller.*;
import ITENodesOfTrees.Module.Node;
import ITENodesOfTrees.Module.RectangleNode;
import ITENodesOfTrees.Module.TreeRectangel;
import ITENodesOfTrees.View.*;
import ITETransTrees.ITETransTrees;
import ITETransTrees.Controller.BinaryTreeController;
import ITETransTrees.Controller.GenericTreeController;
import ITETransTrees.Module.NodeGeneric;
import ITETransTrees.View.DrowTreeUI;
import MainAlgo.ITEMain;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class PanelsController {
    public static JPanel roundedBorder(int n) {
        return new RoundedPanel(n);
    }
    public static JPanel addBtnPanle(int x,int y,String name,Color color){
        JPanel btn=PanelsController.roundedBorder(40);
        btn.setBounds(x, y, 200, 50);
        btn.setOpaque(false);
        JLabel titlebtn = LabelController.addLabel(name, FontController.getPrimaryFont(1, 20), 0, 0,200, 50);
        titlebtn.setForeground(color);
        btn.setLayout(new BorderLayout());
        btn.add(titlebtn,BorderLayout.CENTER);
        return btn;
    }
    public static String backPanel="",preBackPanel="",nowPanel="Home";
    public static void switchPanels(String name,String now,String old) {
        for (JPanel p : MainPanels.Panels) {
            if (p.getName().equals(name)) {
                p.setVisible(true);
                nowPanel=name;
                    backPanel=now;
            } else {
                p.setVisible(false);
            }
        }
    }
    // =========   Action   ==========
    public static void addActionPanel (JPanel panel,String action){
        MouseListener ms = new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                switch (action) {
                    
                    case "ITENODESOFTREE":
                        try {
                            ITENodsOfTreeMain.main(null);
                            ITEMain.mainUI.dispose();
                            
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    break;
                    case "ITETRANSTREES":
                        try {
                            ITETransTrees.main(null);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        ITEMain.mainUI.dispose();
                    break;
                    case "ListOfRectangle":
                        switchPanels("ListOfRectangle","Home","");
                    break;
                    case "RectangelComplete":
                        switchPanels("RectangleComplete","Home","");
                    break;
                    case "Exit":
                        System.exit(0);
                    break;
                    case"addTextFormat":
                        switchPanels("TextFormatInput", "RectangleComplete","Home");
                    break;
                    case"addRectangleFormat":
                        switchPanels("RectangleFormatInput", "RectangleComplete", "Home");
                    break;
                    case "addTreeFormat":   
                            TreeFormatUI.addNodeTree.setVisible(true);
                            TreeFormatUI.outputUI.setVisible(false);
                        clearData();
                        switchPanels("TreeFormatUI", "RectangleComplete", "Home");
                    break;
                    case "EportRectangleFormat":
                        if(nowPanel=="TextFormatInput"){
                            try {
                                TextFormatController.Import(action);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    break;
                    case "back":
                        // clearData();
                        switchPanels(backPanel,"Home",preBackPanel);
                    break;
                    case "backCLC":
                        // clearData();
                        if((backPanel=="RectangleComplete"||backPanel=="Home")){
                            clearData();
                        try {
                            DataBase.resetDataBase();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        }
                        switchPanels(backPanel,"Home",preBackPanel);
                    break;
                    //Q2
                    case "treeGeneric":
                        switchPanels("GenericTreeUI", "HomePageTrans", "");
                    break;
                    default:
                        
                        break;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if(action=="Exit"){
                    
                }else{
                    panel.setBackground(ColorController.getWhiteColor());
                }
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if(action=="Exit"){

                }else{
                    panel.setBackground(Color.decode("#E7E7E7"));
                }
            }
        };
        panel.addMouseListener(ms);
    } 
    public static void addActionOutput (JPanel panel,String action){
        MouseListener ms = new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                switch (action) {
                    //Q1===========================
                    case "rotateRec":
                        if(DataBase.rootRectangle != null){
                            TreeRectangel.rotate(DataBase.rootRectangle);
                            System.out.println("Rotate Done!");
                        }
                    break;
                    case "CheckTree":
                        if(TreeRectangel.checkMerge(DataBase.rootRectangle)){
                            TreeFormatUI.addNodeTree.setVisible(false);
                            TreeFormatUI.outputUI.setVisible(true);
                        }
                    break;
                    case "ShowRectangle":
                        try {
                            DataBase.rootRectangle=RectangleNode.Rectangle(DataBase.Rectangles);
                            if(DataBase.rootRectangle != null){
                                ListOfRectangle.outputUI.setVisible(true);
                                Node.dfs(DataBase.rootRectangle);
                            }
                        } catch (Exception ee) {
                            
                        }
                    break;
                    case "ShowNumberRectangle":
                        try {
                            int num=RectangleNode.NumberOfRectangles(DataBase.Rectangles);
                            ListOfRectangle.numRecProp.setText(String.valueOf(num));
                        } catch (Exception ee) {
                            
                        }
                    break;
                    case "AddRec":
                        if(!(ListOfRectangle.addNodeTree.nameText.getText().equals("") | ListOfRectangle.addNodeTree.widthText.getText().equals("")  | ListOfRectangle.addNodeTree.heightText.getText().equals("") )){
                            String name=ListOfRectangle.addNodeTree.nameText.getText();
                            int width=Integer.parseInt(ListOfRectangle.addNodeTree.widthText.getText());
                            int height=Integer.parseInt(ListOfRectangle.addNodeTree.heightText.getText());
                            if(!(width ==0 || height ==0)){
                                DataBase.Rectangles.add(new Node(name, width, height));
                                ListOfRectangle.numRecNow.setText(String.valueOf(DataBase.Rectangles.size()));
                                ListOfRectangle.addNodeTree.nameText.setText("");
                                ListOfRectangle.addNodeTree.widthText.setText("");
                                ListOfRectangle.addNodeTree.heightText.setText("");
                            }else{
                                System.out.println("Error Input");
                            }
                        }else{
                            System.out.println("Error Input");
                        }
                    break;
                    case "AddTreeBuild":
                        try {
                                if(!(TreeFormatUI.addNodeTree.nameText.getText().equals("") || TreeFormatUI.addNodeTree.widthText.getText().equals("")  | TreeFormatUI.addNodeTree.heightText.getText().equals("") )){
                                    int width=Integer.parseInt(TreeFormatUI.addNodeTree.widthText.getText());
                                    int height=Integer.parseInt(TreeFormatUI.addNodeTree.heightText.getText());
                                    if(!(width ==0 || height ==0)){
                                            TreeFormatController.addNodeToTree(TreeFormatUI.addNodeTree.nameText.getText(), height, width);
                                        if(TreeFormatController.isEndTree(TreeFormatController.treeRoot)){
                                            TreeFormatUI.addNodeTree.widthText.setText("");
                                            TreeFormatUI.addNodeTree.heightText.setText("");
                                            TreeFormatUI.addNodeTree.nameText.setText("");
                                            TreeFormatUI.addNodeTree.nameText.setVisible(false);
                                            TreeFormatUI.addNodeTree.widthText.setVisible(false);
                                            TreeFormatUI.addNodeTree.heightText.setVisible(false);
                                            TreeFormatUI.addNodeTree.btnAdd.setVisible(false);
                                            TreeFormatUI.addNodeTree.titleHeight.setVisible(false);
                                            TreeFormatUI.addNodeTree.titleName.setVisible(false);
                                            TreeFormatUI.addNodeTree.titleWidth.setVisible(false);
                                            TreeFormatUI.addNodeTree.btncheck.setVisible(true);
                                            DataBase.rootRectangle=TreeFormatController.treeRoot;
                                        }
                                    }else{
                                        System.out.println("Error Input");
                                    }
                                    
                                }else{
                                    System.out.println("Error Input");
                                }
                        } catch (Exception i) {
                            
                        }
                    break;
                    case "EportTreeFormat":
                        if(nowPanel.equals("TextFormatInput")){
                            TreeFormatUI.treepanel.updateTree(DataBase.rootRectangle);
                            TreeFormatUI.addNodeTree.setVisible(false);
                            System.out.println("Eport Tree Format Done!");
                            switchPanels("TreeFormatUI", "TextFormatInput", "RectangelComplete");
                        }else if(nowPanel.equals("RectangleFormatInput")){
                            TreeFormatUI.treepanel.updateTree(DataBase.rootRectangle);
                            TreeFormatUI.addNodeTree.setVisible(false);
                            System.out.println("Eport Tree Format Done!");
                            switchPanels("TreeFormatUI", "RectangleFormatInput", "RectangelComplete");
                        }
                    break;
                    case "CheckText":
                        try {
                            TextFormatController.Import(TextFormatUI.inpuTextField.getText());
                            if(TreeRectangel.checkMerge(DataBase.rootRectangle)){
                                TextFormatUI.stateCheck.setText("Done!");
                            TextFormatUI.stateCheck.setVisible(true);
                            TextFormatUI.outputUI.setVisible(true);
                            ImageController.playSound("resources\\images\\ngp.wav");
                            }else{
                                TextFormatUI.stateCheck.setText("Error input width or heigth!!");
                                TextFormatUI.outputUI.setVisible(false);
                                TextFormatUI.stateCheck.setVisible(true);
                            }
                        } catch (Exception i) {
                            TextFormatUI.stateCheck.setText("Error input!!");
                            TextFormatUI.outputUI.setVisible(false);
                            TextFormatUI.stateCheck.setVisible(true);
                        }
                    break;
                    case "OpenFile":
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.edit(DataBase.inputFile);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    break;
                    case "CheckFile":
                        try {
                            String[] s=RectangleFormatController.readFileToStringArray();
                            RectangleFormatController.Import(s);
                            RectangleFormatUI.stateCheck.setText("Done!");
                            RectangleFormatUI.stateCheck.setVisible(true);
                            RectangleFormatUI.outputUI.setVisible(true);
                            RectangleFormatUI.rotateCheck.setVisible(true);
                        } catch (Exception i) {
                            RectangleFormatUI.stateCheck.setText("Error input!!");
                            RectangleFormatUI.outputUI.setVisible(false);
                            RectangleFormatUI.stateCheck.setVisible(true);
                            RectangleFormatUI.rotateCheck.setVisible(false);
                        }
                    break;
                    case "Clear":
                        clearData();
                        try {
                            DataBase.resetDataBase();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    break;
                    case "EportRectangleFormat":
                        
                        if(nowPanel=="TextFormatInput" || nowPanel=="ListOfRectangle" ||nowPanel=="TreeFormatUI" ||nowPanel=="RectangleFormatInput"){
                            RectangleFormatController.Export(DataBase.rootRectangle);
                            System.out.println("Eport Rectangle Format Done!");
                        }
                    break;
                    case "EportTextFormat":
                        if(nowPanel=="RectangleFormatInput" || nowPanel=="ListOfRectangle" ||nowPanel=="TreeFormatUI"){
                            TextFormatUI.inpuTextField.setText(TextFormatController.export(DataBase.rootRectangle));
                            System.out.println("Eport Text Format Done!");
                            switchPanels("TextFormatInput", nowPanel, "EportRectangleFormat");
                        }
                    break;
                    //Q2 =========================
                    case "ConvertBtoG":
                        BinaryTreeController.convertBtoG(DataBase.B_root);
                        System.out.println("Binary Tree:");
                        NodeGeneric pp = new NodeGeneric();
                        pp.value = "parent";
                        GenericTreeController.dfs(DataBase.B_root,pp);
                        System.out.println("Genreic Tree:");
                        GenericTreeController.Export();
                        GenericTreeController.printGenericTree();
                        System.out.println("------------------------");
                    break;
                    case "ConvertGtoB":
                        try {
                            GenericTreeController.Import(GenericTreeController.readFileToStringArray());
                            if(DataBase.G_root!=null){
                                System.out.println("Genreic Tree:");
                            GenericTreeController.Export();
                            GenericTreeController.printGenericTree();
                            }
                            switchPanels("DrawerUI", "GenericTreeUI", "HomePageTrans");
                            GenericTreeController.convertGtoB(DataBase.G_root);
                            DrowTreeUI.drawTreeGeneric.updateTree(DataBase.G_root);
                            NodeGeneric p = new NodeGeneric();
                            System.out.println("Binary Tree:");
                            p.value = "parent";
                            GenericTreeController.dfs(DataBase.B_root,p);
                            DrowTreeUI.treePanel.updateTree(NodeGeneric.convert(DataBase.B_root));
                            Node.dfs(NodeGeneric.convert(DataBase.B_root));
                            System.out.println();
                            System.out.println("------------------------");
                        } catch (Exception ee) {
                           
                        }
                    break;
                    case "ClearQ2":
                        try {
                            DataBase.resetDataBase();
                            System.out.println("Clear Done!");
                        } catch (IOException e1) {
                           
                            e1.printStackTrace();
                        }

                    break;
                    default:
                        
                        break;
                }
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
    
            }
        };
        panel.addMouseListener(ms);

    } 
    public static void disableKeyboardInput(JTextPane textPane) {
        ((AbstractDocument) textPane.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                
            }
        });
        textPane.setFocusable(false);
    }
    public static void clearData(){
        System.out.println("Clearing..");
                        
                        ListOfRectangle.numRecNow.setText("0");
                        ListOfRectangle.outputUI.setVisible(false);
                        ListOfRectangle.numRecProp.setText("0");
                        TextFormatUI.inpuTextField.setText("");
                        TextFormatUI.outputUI.setVisible(false);
                        TextFormatUI.stateCheck.setVisible(false);
                        RectangleFormatUI.outputUI.setVisible(false);
                        RectangleFormatUI.stateCheck.setVisible(false);
                        TreeFormatController.treeRoot=null;
                        TreeFormatUI.treepanel.updateTree(new Node());
                        if(nowPanel.equals("TreeFormatUI")){
                            TreeFormatUI.addNodeTree.widthText.setText("");
                            TreeFormatUI.addNodeTree.heightText.setText("");
                            TreeFormatUI.addNodeTree.nameText.setText("");
                            TreeFormatUI.addNodeTree.nameText.setVisible(true);
                            TreeFormatUI.addNodeTree.widthText.setVisible(true);
                            TreeFormatUI.addNodeTree.heightText.setVisible(true);
                            TreeFormatUI.addNodeTree.btnAdd.setVisible(true);
                            TreeFormatUI.addNodeTree.titleHeight.setVisible(true);
                            TreeFormatUI.addNodeTree.titleName.setVisible(true);
                            TreeFormatUI.addNodeTree.titleWidth.setVisible(true);
                            TreeFormatUI.addNodeTree.btncheck.setVisible(false);
                        }
                        
    }
}
