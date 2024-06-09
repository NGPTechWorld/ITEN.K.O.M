package ITENodesOfTrees.View;

import java.awt.BorderLayout;
import javax.swing.*;

import ControllersUI.*;
import java.awt.event.*;

public class TextFormatUI extends JPanel{
    public static JLabel iconExit,stateCheck;
    public static OutputUI outputUI;
    public static JTextPane inpuTextField;
    public TextFormatUI(){
        initComponents();
    }
    private void initComponents(){
        outputUI=new OutputUI();
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
        PanelsController.addActionPanel(backP,"backCLC");
        backP.add(ImageController.addPhoto("back.png", 60, 60),BorderLayout.CENTER);
        add(backP);
        JPanel textPanel=PanelsController.roundedBorder(30);
        textPanel.setOpaque(false);
        textPanel.setBounds(50,150,1180,80);
        textPanel.setLayout(null);
        textPanel.setBackground(ColorController.getWhiteColor());
        inpuTextField=new JTextPane();
        inpuTextField.setBorder(null);
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
        JPanel btnCheck=PanelsController.addBtnPanle(300, 300, "Check", ColorController.firstColor());
        PanelsController.addActionOutput(btnCheck, "CheckText");
        JPanel btnRset=PanelsController.addBtnPanle(600, 300, "Clear", ColorController.secoundColor());
        PanelsController.addActionOutput(btnRset, "Clear");
        stateCheck = LabelController.addLabel("", FontController.getPrimaryFont(1, 20), 20, 225,300, 50);
        stateCheck.setForeground(ColorController.secoundColorlight2());
        textPanel.add(scrollPane);
        add(inputlabel);
        add(outputUI);
        add(btnRset);
        add(btnCheck);
        add(textPanel);
        add(stateCheck);
        add(titlePage);
        outputUI.setVisible(false);
        stateCheck.setVisible(false);
}
}