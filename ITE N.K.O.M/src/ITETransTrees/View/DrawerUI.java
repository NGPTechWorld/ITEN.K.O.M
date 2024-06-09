package ITETransTrees.View;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ControllersUI.ColorController;
import ControllersUI.FontController;
import ControllersUI.ImageController;
import ControllersUI.LabelController;
import ControllersUI.MainPanels;
import ControllersUI.PanelsController;
import ITENodesOfTrees.View.TreePanel;

public class DrawerUI extends JPanel{
    public static JLabel iconExit,stateCheck;
    public static JPanel textPanel;
    public static TreePanel treePanel;
    public static DrawTreeGeneric drawTreeGeneric;
    public DrawerUI(){
        initComponents();
    }
    private void initComponents(){

        setName("DrawerUI");
        setBounds(0, 10, 1280, 700);
        setLayout(null);
        setOpaque(false);
        JLabel titlePage = LabelController.addLabel("Drawer Trees", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
        JLabel genericLabel = LabelController.addLabel("Generic Tree", FontController.getPrimaryFont(1, 30), 0, 110,600, 50);
        genericLabel.setForeground(ColorController.getWhiteColor());
        JLabel binaryLabel = LabelController.addLabel("Binary Tree", FontController.getPrimaryFont(1, 30), 600, 110,600, 50);
        binaryLabel.setForeground(ColorController.getWhiteColor());
        titlePage.setForeground(ColorController.getWhiteColor());
        
        JPanel backP=new JPanel();
        backP.setBounds(1000, 50, 60, 60);
        backP.setLayout(new BorderLayout());
        backP.setOpaque(false);
        PanelsController.addActionPanel(backP,"backCLC");
        backP.add(ImageController.addPhoto("back.png", 60, 60),BorderLayout.CENTER);
        add(backP);

        JPanel btnConvert=PanelsController.addBtnPanle(600, 650, "Convert B to G", ColorController.firstColor());
        PanelsController.addActionOutput(btnConvert, "ConvertBtoG");
        

        treePanel=new TreePanel();
        treePanel.setBounds(650, 170,610, 600);
        drawTreeGeneric=new DrawTreeGeneric();
        drawTreeGeneric.setBounds(10, 170,610, 600);
 
        add(binaryLabel);
        add(genericLabel);
        add(btnConvert);

        add(titlePage);
        add(treePanel);
        add(drawTreeGeneric);

}
}
