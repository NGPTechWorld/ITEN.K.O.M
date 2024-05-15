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
import Controller.FontController;
import Controller.ImageController;
import Controller.LabelController;
import Controller.PanelsController;
import Module.CustomScrollBarUI;
import Module.RoundedPanel;

public class TextFormatInput extends JPanel{
    public static JLabel iconExit;
    public static JTextPane inpuTextField;
    public TextFormatInput(){
        initComponents();
    }
    private void initComponents(){
        setName("TextFormatInput");
        setBounds(0, 10, 1280, 700);
        setLayout(null);
        setOpaque(false);
        JLabel titlePage = LabelController.addLabel("Add Text Rectangle", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
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
        

        JPanel textPanel=PanelsController.roundedBorder(30);
        textPanel.setOpaque(false);
        textPanel.setBounds(50,150,1180,80);
        textPanel.setLayout(null);
        textPanel.setBackground(ColorController.getWhiteColor());
        inpuTextField=new JTextPane();
        inpuTextField.setBorder(null);
        //inpuTextField.setHorizontalAlignment(JTextField.CENTER);
        inpuTextField.setFont(FontController.getPrimaryFont(0, 30));
        JScrollPane scrollPane = new JScrollPane(inpuTextField);
        JScrollBar scrollBar = scrollPane.getHorizontalScrollBar();
        scrollBar.setUI(new CustomScrollBarUI());

        scrollPane.setBounds(10,10,1160,60);
        scrollPane.setBorder(null);
        inpuTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); 
                    System.out.println(inpuTextField.getText());
                }
            }
        });
        JLabel errorJLabel = LabelController.addLabel("Error input!!", FontController.getPrimaryFont(1, 20), 20, 225,200, 50);
        errorJLabel.setForeground(ColorController.secoundColorlight2());
        //scrollPane.getVerticalScrollBar().setUnitIncrement(40);
        // inpuTextField.setLineWrap(true);
        // inpuTextField.setWrapStyleWord(false); 
        textPanel.add(scrollPane);
        add(inputlabel);
        add(new OutputUI());
        add(textPanel);
        add(errorJLabel);
        add(titlePage);
}
}