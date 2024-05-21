package ITENodesOfTrees.View;

import java.awt.*;
import javax.swing.*;
import ControllersUI.*;


public class TreeFormatUI extends JPanel{
    public static JLabel iconExit,stateCheck;
    public static OutputUI outputUI;
    public static JTextPane inpuTextField;
    public static JPanel textPanel;
    public static AddNodeTree addNodeTree;
    public static BinaryTreePanel bt;
    public TreeFormatUI(){
        initComponents();
    }
    private void initComponents(){
        outputUI=new OutputUI();
        setName("TreeFormatUI");
        setBounds(0, 10, 1280, 700);
        setLayout(null);
        setOpaque(false);
        JLabel titlePage = LabelController.addLabel("Tree Rectangle", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
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

        JPanel btnRset=PanelsController.addBtnPanle(770, 640, "Clear", ColorController.secoundColor());
        PanelsController.addActionOutput(btnRset, "Clear");
        stateCheck = LabelController.addLabel("Error!", FontController.getPrimaryFont(1, 20), 20, 250,200, 50);
        stateCheck.setForeground(ColorController.secoundColorlight2());
        bt=new BinaryTreePanel();
        
        JScrollPane scrollPane = new JScrollPane(bt);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setBounds(20,90,1240,390);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar scrollBar1 = scrollPane.getHorizontalScrollBar();
        scrollBar1.setUI(new CustomScrollBarUI());
        JScrollBar scrollBar2 = scrollPane.getVerticalScrollBar();
        scrollBar2.setUI(new CustomScrollBarUI());
        addNodeTree=new AddNodeTree();
        add(addNodeTree);
        add(outputUI);
        add(scrollPane);
        add(btnRset);
        add(titlePage);
        outputUI.setVisible(false);
}
}