package ITETransTrees.View;

import java.awt.*;
import javax.swing.*;

import ControllersUI.*;
import ITENodesOfTrees.View.*;

import java.awt.event.*;

public class GenericTreeUI extends JPanel{
    public static JLabel iconExit,stateCheck;
    public static JPanel textPanel;
    public GenericTreeUI(){
        initComponents();
    }
    private void initComponents(){

        setName("GenericTreeUI");
        setBounds(0, 10, 1280, 700);
        setLayout(null);
        setOpaque(false);
        JLabel titlePage = LabelController.addLabel("Add Generic Tree", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
        JLabel inputlabel = LabelController.addLabel("Input", FontController.getPrimaryFont(1, 36), 0, 90,200, 50);
        inputlabel.setForeground(ColorController.getWhiteColor());
        titlePage.setForeground(ColorController.getWhiteColor());
        
        JPanel backP=new JPanel();
        backP.setBounds(1000, 50, 60, 60);
        backP.setLayout(new BorderLayout());
        backP.setOpaque(false);
        PanelsController.addActionPanel(backP,"backCLC");
        backP.add(ImageController.addPhoto("back.png", 60, 60),BorderLayout.CENTER);
        add(backP);
        
        JPanel btnOpenfile=PanelsController.addBtnPanle(270, 200, "OpenFile", ColorController.firstColorDark());
        PanelsController.addActionOutput(btnOpenfile, "OpenFile");
        JPanel btnCheck=PanelsController.addBtnPanle(520, 200, "Check", ColorController.firstColor());
        PanelsController.addActionOutput(btnCheck, "ConvertGtoB");
        JPanel btnRset=PanelsController.addBtnPanle(770, 200, "Clear", ColorController.secoundColor());
        PanelsController.addActionOutput(btnRset, "ClearQ2");
        stateCheck = LabelController.addLabel("Error!", FontController.getPrimaryFont(1, 20), 20, 250,200, 50);
        stateCheck.setForeground(ColorController.secoundColorlight2());
        //scrollPane.getVerticalScrollBar().setUnitIncrement(40);
        // inpuTextField.setLineWrap(true);
        // inpuTextField.setWrapStyleWord(false); 

        add(inputlabel);
        add(btnRset);
        add(btnOpenfile);
        add(btnCheck);
        add(stateCheck);
        add(titlePage);

        stateCheck.setVisible(false);
}
}
