package View.ITENodesOfTress;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import Controller.ColorController;
import Controller.FontController;
import Controller.ImageController;
import Controller.LabelController;
import Controller.PanelsController;

public class RectangleComplete extends JPanel{
    public static JLabel iconExit;
    public RectangleComplete(){
        initComponents();
    }
    private void initComponents(){
        setName("RectangleComplete");
        setBounds(0, 10, 1280, 700);
        setLayout(null);
        setOpaque(false);
        JLabel titlePage = LabelController.addLabel("Add Rectangle Complete", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
        JLabel titleBoxleft = LabelController.addLabel("Tree Rectangle", FontController.getPrimaryFont(1, 28), 890, 600,300, 50);
        JLabel titleBoxcenter = LabelController.addLabel("Drow Rectangle", FontController.getPrimaryFont(1, 28), 50, 600,400, 50);
        JLabel titleBoxright = LabelController.addLabel("Text Rectangle", FontController.getPrimaryFont(1, 28), 450, 600,400, 50);
        JPanel addTreeFormat=PanelsController.roundedBorder(60);
        JPanel addRectangleFormat=PanelsController.roundedBorder(60);
        JPanel addTextFormat=PanelsController.roundedBorder(60);

        titlePage.setForeground(ColorController.getWhiteColor());
        titleBoxcenter.setForeground(ColorController.getWhiteColor());
        titleBoxleft.setForeground(ColorController.getWhiteColor());
        titleBoxright.setForeground(ColorController.getWhiteColor());

        addTreeFormat.setName("addTreeFormat");
        addTreeFormat.setOpaque(false);
        addTreeFormat.setBackground(Color.decode("#E7E7E7"));
        addTreeFormat.setLayout(new BorderLayout());
        addTreeFormat.setBounds(890, 150, 300, 400);
        iconExit=ImageController.addPhoto("treeRectandle.png",200,200);
        addTreeFormat.add(iconExit,BorderLayout.CENTER);
        
        PanelsController.addActionPanel(addTreeFormat, "addTreeFormat");

        addRectangleFormat.setName("addRectangleFormat");
        addRectangleFormat.setOpaque(false);
        addRectangleFormat.setBackground(Color.decode("#E7E7E7"));
        addRectangleFormat.setLayout(new BorderLayout());
        addRectangleFormat.setBounds(90, 150, 300, 400);
        addRectangleFormat.add(ImageController.addPhoto("rectangel.png",280,280),BorderLayout.CENTER);
        PanelsController.addActionPanel(addRectangleFormat, "addRectangleFormat");

        addTextFormat.setName("addTextFormat");
        addTextFormat.setOpaque(false);
        addTextFormat.setBackground(Color.decode("#E7E7E7"));
        addTextFormat.setLayout(new BorderLayout());
        addTextFormat.setBounds(490, 150, 300, 400);
        addTextFormat.add(ImageController.addPhoto("textRectangle.png",280,280),BorderLayout.CENTER);
        PanelsController.addActionPanel(addTextFormat, "addTextFormat");
        
        JPanel backP=new JPanel();
        backP.setBounds(1000, 50, 60, 60);
        backP.setLayout(new BorderLayout());
        backP.setOpaque(false);
        PanelsController.addActionPanel(backP,"back");
        backP.add(ImageController.addPhoto("back.png", 60, 60),BorderLayout.CENTER);
        add(backP);
        add(addTreeFormat);
        add(addRectangleFormat);
        add(addTextFormat);
        add(titleBoxcenter);
        add(titleBoxleft);
        add(titleBoxright);
        add(titlePage);
    }
}
