package ITENodesOfTrees.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ControllersUI.ColorController;
import ControllersUI.FontController;
import ControllersUI.ImageController;
import ControllersUI.LabelController;
import ControllersUI.PanelsController;
import ITENodesOfTrees.Module.*;


public class AddNodeTree extends JLabel {
    public static JTextField nameText,widthText,heightText;
    public static JLabel iconExit,titleName,titleWidth,titleHeight;
    public static JPanel btnAdd,btnClc,btncheck;
    public AddNodeTree(){
        initComponents();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = ColorController.firstColorDark();
        Color color2 = ColorController.secoundColorDark();
        GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
    private void initComponents(){
        setName("InputTree");
        setBounds(0, 500, 1280, 200);
        setLayout(null);
        setOpaque(true);
        setBackground(ColorController.getBlackColor());
        JLabel titlePage = LabelController.addLabel("Input", FontController.getPrimaryFont(1, 36), 0, 0,200, 50);
        titlePage.setForeground(ColorController.getWhiteColor());
        
        titleName = LabelController.addLabel("Name Node:", FontController.getPrimaryFont(1, 24), 50, 80,200, 50);
        titleName.setForeground(ColorController.getWhiteColor());
        nameText=new JTextField();
        nameText.setBounds(250, 85, 200, 40);
        nameText.setFont(FontController.getPrimaryFont(0, 24));
        
        titleWidth = LabelController.addLabel("Width Node:", FontController.getPrimaryFont(1, 24), 500, 30,200, 50);
        titleWidth.setForeground(ColorController.getWhiteColor());
        widthText=new JTextField();
        widthText.setBounds(700, 35, 100, 40);
        widthText.setFont(FontController.getPrimaryFont(0, 24));
        
        titleHeight = LabelController.addLabel("Height Node:", FontController.getPrimaryFont(1, 24), 500, 120,200, 50);
        titleHeight.setForeground(ColorController.getWhiteColor());
        heightText=new JTextField();
        heightText.setBounds(700, 125, 100, 40);
        heightText.setFont(FontController.getPrimaryFont(0, 24));

        btnAdd=PanelsController.addBtnPanle(950, 30, "Add Node", ColorController.firstColorDark());
        PanelsController.addActionOutput(btnAdd, "AddTreeBuild");
        btnClc=PanelsController.addBtnPanle(950, 110, "Clear", ColorController.secoundColorDark());
        PanelsController.addActionOutput(btnClc, "Clear");
        btncheck=PanelsController.addBtnPanle(950, 30, "Check Tree", ColorController.firstColor());
        PanelsController.addActionOutput(btncheck, "Clear");
        
        add(btnAdd);
        add(btncheck);
        btncheck.setVisible(false);
        add(btnClc);
        add(nameText);
        add(titleName);
        add(titleHeight);
        add(heightText);
        add(titleWidth);
        add(widthText);
        add(titlePage);
    }

}
