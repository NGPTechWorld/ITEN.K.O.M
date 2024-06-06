package ITENodesOfTrees.View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import ControllersUI.ColorController;
import ControllersUI.FontController;
import ControllersUI.ImageController;
import ControllersUI.LabelController;
import ControllersUI.PanelsController;

public class ListOfRectangle extends JPanel{
    public static JLabel iconExit,numRecNow,numRecProp;
    public static AddNodeTree addNodeTree;
    public static OutputUI outputUI;
    public ListOfRectangle(){
        initComponents();
    }
    private void initComponents(){
        setName("ListOfRectangle");
        setBounds(0, 10, 1280, 700);
        setLayout(null);
        setOpaque(false);
        JLabel titlePage = LabelController.addLabel("Add List Of Rectangle", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
        titlePage.setForeground(ColorController.getWhiteColor());
      
        //========
        outputUI=new OutputUI();
        addNodeTree=new AddNodeTree();
        addNodeTree.setBounds(0, 130, 1280, 200);
        PanelsController.addActionOutput(addNodeTree.btnAdd, "AddRec");
        JPanel btnShowNumberRecNow=PanelsController.addBtnPanle(200, 360, "Show Rectangle", ColorController.firstColor());
        PanelsController.addActionOutput(btnShowNumberRecNow, "ShowRectangle");
        JLabel titlenumRecNow=LabelController.addLabel("Number of Rectangle Added : ", FontController.getPrimaryFont(1, 22), 100, 430,350, 50);
        numRecNow=LabelController.addLabel("0", FontController.getPrimaryFont(1, 22), 400, 430,200, 50);
        titlenumRecNow.setForeground(ColorController.getWhiteColor());
        numRecNow.setForeground(ColorController.getWhiteColor());
        btnShowNumberRecNow.setSize(300, 50);
        
        JPanel btnShoRec=PanelsController.addBtnPanle(800, 360, "Show Number Rectangle", ColorController.secoundColor());
        PanelsController.addActionOutput(btnShoRec, "ShowNumberRectangle");
        JLabel titlenumRecProp=LabelController.addLabel("Posible Number of Rectangle : ", FontController.getPrimaryFont(1, 22), 700, 430,350, 50);
        numRecProp=LabelController.addLabel("0", FontController.getPrimaryFont(1, 22), 1000, 430,200, 50);
        titlenumRecProp.setForeground(ColorController.getWhiteColor());
        numRecProp.setForeground(ColorController.getWhiteColor());
        btnShoRec.setSize(300, 50);
        //===========
        JPanel backP=new JPanel();
        backP.setBounds(1000, 50, 60, 60);
        backP.setLayout(new BorderLayout ());
        backP.setOpaque(false);
        PanelsController.addActionPanel(backP,"back");
        backP.add(ImageController.addPhoto("back.png", 60, 60),BorderLayout.CENTER);
        add(addNodeTree);
        add(backP);
        add(outputUI);
        add(titlenumRecProp);
        add(numRecProp);
        add(btnShoRec);
        add(titlePage);
        add(titlenumRecNow);
        add(numRecNow);
        add(btnShowNumberRecNow);
        outputUI.setVisible(false);
    }
}
