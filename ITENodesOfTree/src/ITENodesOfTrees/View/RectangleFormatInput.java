package ITENodesOfTrees.View;

import java.awt.*;
import javax.swing.*;
import ControllersUI.*;
import java.awt.event.*;

public class RectangleFormatInput extends JPanel{
    public static JLabel iconExit,stateCheck;
    public static OutputUI outputUI;
    public static JTextPane inpuTextField;
    public static JPanel textPanel;
    public RectangleFormatInput(){
        initComponents();
    }
    private void initComponents(){
        outputUI=new OutputUI();
        setName("RectangleFormatInput");
        setBounds(0, 10, 1280, 700);
        setLayout(null);
        setOpaque(false);
        JLabel titlePage = LabelController.addLabel("Drow Rectangle", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
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
        

        textPanel=PanelsController.roundedBorder(30);
        textPanel.setOpaque(false);
        textPanel.setBounds(50,350,1180,80);
        textPanel.setLayout(null);
        textPanel.setBackground(ColorController.getWhiteColor());
        inpuTextField=new JTextPane();
        inpuTextField.setBorder(null);
        //inpuTextField.setHorizontalAlignment(JTextField.CENTER);
        inpuTextField.setFont(FontController.getPrimaryFont(0, 30));
        //inpuTextField.setEnabled(false);
        //PanelsController.disableKeyboardInput(inpuTextField);
        inpuTextField.setDisabledTextColor(ColorController.getBlackColor());
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
        JPanel btnOpenfile=PanelsController.addBtnPanle(270, 200, "OpenFile", ColorController.firstColorDark());
        PanelsController.addActionOutput(btnOpenfile, "OpenFile");
        JPanel btnCheck=PanelsController.addBtnPanle(520, 200, "Check", ColorController.firstColor());
        PanelsController.addActionOutput(btnCheck, "CheckFile");
        JPanel btnRset=PanelsController.addBtnPanle(770, 200, "Clear", ColorController.secoundColor());
        PanelsController.addActionOutput(btnRset, "Clear");
        stateCheck = LabelController.addLabel("Error!", FontController.getPrimaryFont(1, 20), 20, 250,200, 50);
        stateCheck.setForeground(ColorController.secoundColorlight2());
        //scrollPane.getVerticalScrollBar().setUnitIncrement(40);
        // inpuTextField.setLineWrap(true);
        // inpuTextField.setWrapStyleWord(false); 
        textPanel.add(scrollPane);
        add(inputlabel);
        add(outputUI);
        add(btnRset);
        add(btnOpenfile);
        add(btnCheck);
        add(textPanel);
        add(stateCheck);
        add(titlePage);
        outputUI.setVisible(false);
        textPanel.setVisible(false);
        stateCheck.setVisible(false);
}
}