package ControllersUI;

import javax.swing.*;
import javax.swing.text.*;

import ITENodesOfTrees.ITENodsOfTree;
import ITENodesOfTrees.Controller.*;
import ITENodesOfTrees.Module.Node;
import ITENodesOfTrees.View.*;
import ITETransTrees.ITETransTrees;
import MainAlgo.ITEmain;

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
    public static void addActionPanel (JPanel panel,String action){
        MouseListener ms = new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                switch (action) {
                    case "ITENODESOFTREE":
                        try {
                            ITENodsOfTree.main(null);
                            ITEmain.mainUI.dispose();
                            
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    break;
                    case "ITETRANSTREES":
                        ITETransTrees.main(null);
                        ITEmain.mainUI.dispose();
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
                        if(DataBase.rootRectangle==null)
                            TreeFormatUI.addNodeTree.setVisible(true);
                        switchPanels("TreeFormatUI", "RectangleComplete", "Home");
                    break;
                    case "EportRectangleFormat":
                        if(nowPanel=="TextFormatInput"){
                            TextFormatController.Import(action);
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
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        }
                        switchPanels(backPanel,"Home",preBackPanel);
                        
                        
                    break;
                    default:
                        //switchPanels(action);
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
                    case "AddTreeBuild":
                        try {
                            String name=AddNodeTree.nameText.getText();
                                // int width=Integer.parseInt(AddNodeTree.widthText.getText());
                                // int height=Integer.parseInt(AddNodeTree.heightText.getText());
                            if(nowPanel.equals("addTreeFormat")){
                                
                                TreeFormatController.addNodeToTree(name, 10, 11);
                                if(TreeFormatController.isEndTree(TreeFormatController.treeRoot)){
                                    AddNodeTree.nameText.setVisible(false);
                                    AddNodeTree.widthText.setVisible(false);
                                    AddNodeTree.heightText.setVisible(false);
                                    AddNodeTree.btnAdd.setVisible(false);
                                    AddNodeTree.titleHeight.setVisible(false);
                                    AddNodeTree.titleName.setVisible(false);
                                    AddNodeTree.titleWidth.setVisible(false);
                                    AddNodeTree.btncheck.setVisible(true);
                                }
                            }
                            
                        } catch (Exception i) {
                            
                        }
                       
                    break;
                    case "EportTreeFormat":
                        if(nowPanel.equals("TextFormatInput")){
                            TreeFormatUI.bt.updateTree(DataBase.rootRectangle);
                            TreeFormatUI.addNodeTree.setVisible(false);
                            switchPanels("TreeFormatUI", "TextFormatInput", "RectangelComplete");
                        }else if(nowPanel.equals("RectangleFormatInput")){
                            TreeFormatUI.bt.updateTree(DataBase.rootRectangle);
                            TreeFormatUI.addNodeTree.setVisible(false);
                            switchPanels("TreeFormatUI", "RectangleFormatInput", "RectangelComplete");
                        }
                        
                    break;
                    case "CheckText":
                        try {
                            TextFormatController.Import(TextFormatInput.inpuTextField.getText());
                            TextFormatInput.stateCheck.setText("Done!");
                            TextFormatInput.stateCheck.setVisible(true);
                            TextFormatInput.outputUI.setVisible(true);
                            ImageController.playSound("resources\\images\\ngp.wav");
                        } catch (Exception i) {
                            TextFormatInput.stateCheck.setText("Error input!!");
                            TextFormatInput.outputUI.setVisible(false);
                            TextFormatInput.stateCheck.setVisible(true);
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
                            
                            // RectangleFormatInput.inpuTextField.setText();
                            RectangleFormatUI.stateCheck.setVisible(true);
                            RectangleFormatUI.outputUI.setVisible(true);
                        } catch (Exception i) {
                            RectangleFormatUI.stateCheck.setText("Error input!!");
                            RectangleFormatUI.outputUI.setVisible(false);
                            RectangleFormatUI.stateCheck.setVisible(true);
                        }
                        
                        
                    break;
                    case "Clear":
                        clearData();
                        try {
                            DataBase.resetDataBase();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    break;
                    case "EportRectangleFormat":
                        if(nowPanel=="TextFormatInput"){
                            RectangleFormatController.Export(DataBase.rootRectangle);
                        }
                    break;
                    case "EportTextFormat":
                        if(nowPanel=="RectangleFormatInput"){
                            TextFormatInput.inpuTextField.setText(TextFormatController.export(DataBase.rootRectangle));
                            switchPanels("TextFormatInput", "RectangleFormatInput", "EportRectangleFormat");
                        }
                    break;
                    default:
                        //switchPanels(action);
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
                        TextFormatInput.inpuTextField.setText("");
                        TextFormatInput.outputUI.setVisible(false);
                        TextFormatInput.stateCheck.setVisible(false);
                        RectangleFormatUI.inpuTextField.setText("");
                        RectangleFormatUI.textPanel.setVisible(false);
                        RectangleFormatUI.outputUI.setVisible(false);
                        RectangleFormatUI.stateCheck.setVisible(false);
                        TreeFormatController.treeRoot=null;
                        TreeFormatUI.bt.updateTree(new Node());
                        if(nowPanel=="TreeFormatUI"){
                            AddNodeTree.nameText.setVisible(true);
                            AddNodeTree.widthText.setVisible(true);
                            AddNodeTree.heightText.setVisible(true);
                            AddNodeTree.btnAdd.setVisible(true);
                            AddNodeTree.titleHeight.setVisible(true);
                            AddNodeTree.titleName.setVisible(true);
                            AddNodeTree.titleWidth.setVisible(true);
                            AddNodeTree.btncheck.setVisible(false);
                        }
                        
    }
}
