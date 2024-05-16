package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.event.*;
import Controller.ColorController;
import Controller.DataBase;
import Controller.FontController;
import Controller.ImageController;
import Controller.LabelController;
import Controller.PanelsController;
import Module.CustomScrollBarUI;
import Module.RoundedPanel;

public class DrowTreeUI extends JPanel{
    public static JLabel iconExit,stateCheck;
    public static OutputUI outputUI;
    public static JTextPane inpuTextField;
    public static JPanel textPanel;
    public static BinaryTreePanel bt;
    public DrowTreeUI(){
        initComponents();
    }
    private void initComponents(){
        outputUI=new OutputUI();
        setName("DrowTreeUI");
        setBounds(0, 10, 1280, 700);
        setLayout(null);
        setOpaque(false);
        JLabel titlePage = LabelController.addLabel("Drow Tree Rectangle", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
        JLabel inputlabel = LabelController.addLabel("Input", FontController.getPrimaryFont(1, 36), 0, 90,200, 50);
        inputlabel.setForeground(ColorController.getWhiteColor());
        titlePage.setForeground(ColorController.getWhiteColor());
        
        JPanel backP=new JPanel();
        backP.setBounds(1000, 50, 60, 60);
        backP.setLayout(new BorderLayout());
        backP.setOpaque(false);
        PanelsController.addActionPanel(backP,"back");
        backP.add(ImageController.addPhoto("back.png", 60, 60),BorderLayout.CENTER);
        add(backP);

        JPanel btnRset=PanelsController.addBtnPanle(770, 640, "Clear", ColorController.secoundColor());
        PanelsController.addActionOutput(btnRset, "Clear");
        stateCheck = LabelController.addLabel("Error!", FontController.getPrimaryFont(1, 20), 20, 250,200, 50);
        stateCheck.setForeground(ColorController.secoundColorlight2());
        bt=new BinaryTreePanel();
        
        JScrollPane scrollPane = new JScrollPane(bt);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setBounds(20,120,1240,500);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(outputUI);
        add(scrollPane);
        add(btnRset);
        add(titlePage);
        outputUI.setVisible(false);
}
}