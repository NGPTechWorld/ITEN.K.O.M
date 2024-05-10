package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import Controller.ColorController;
import Controller.FontController;
import Controller.ImageController;
import Controller.LabelController;
import Controller.PanelsController;

public class RectangleComplete extends JPanel{
    public RectangleComplete(){
        initComponents();
    }
    private void initComponents(){
        setName("RectangleComplete");
        setBounds(0, 10, 1280, 700);
        setLayout(null);
        setOpaque(false);
        JLabel titlePage = LabelController.addLabel("Add Rectangle Complete", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
        JLabel titleBoxleft = LabelController.addLabel("Tree Rectangle", FontController.getPrimaryFont(1, 28), 90, 600,300, 50);
        JLabel titleBoxcenter = LabelController.addLabel("Drow Rectangle", FontController.getPrimaryFont(1, 28), 450, 600,400, 50);
        JLabel titleBoxright = LabelController.addLabel("Text Rectangle", FontController.getPrimaryFont(1, 28), 850, 600,400, 50);
        JPanel addTreeFormat=PanelsController.roundedBorder(60);
        JPanel addRectangleFormat=PanelsController.roundedBorder(60);
        JPanel addTextFormat=PanelsController.roundedBorder(60);

        titlePage.setForeground(ColorController.getWhiteColor());
        titleBoxcenter.setForeground(ColorController.getWhiteColor());
        titleBoxleft.setForeground(ColorController.getWhiteColor());
        titleBoxright.setForeground(ColorController.getWhiteColor());

        addTreeFormat.setName("addTreeFormat");
        addTreeFormat.setOpaque(false);
        addTreeFormat.setBackground(Color.decode("#EEEEEE"));
        addTreeFormat.setLayout(new BorderLayout());
        addTreeFormat.setBounds(100, 150, 300, 400);
        addTreeFormat.add(ImageController.addPhoto("treeRectandle.png",200,200),BorderLayout.CENTER);
        PanelsController.addActionPanel(addTreeFormat, "addTreeFormat");

        addRectangleFormat.setName("addRectangleFormat");
        addRectangleFormat.setOpaque(false);
        addRectangleFormat.setBackground(Color.decode("#EEEEEE"));
        addRectangleFormat.setLayout(new BorderLayout());
        addRectangleFormat.setBounds(500, 150, 300, 400);
        addRectangleFormat.add(ImageController.addPhoto("rectangel.png",280,280),BorderLayout.CENTER);
        PanelsController.addActionPanel(addRectangleFormat, "addRectangleFormat");

        addTextFormat.setName("addTextFormat");
        addTextFormat.setOpaque(false);
        addTextFormat.setBackground(Color.decode("#EEEEEE"));
        addTextFormat.setLayout(new BorderLayout());
        addTextFormat.setBounds(900, 150, 300, 400);
        addTextFormat.add(ImageController.addPhoto("textRectangle.png",280,280),BorderLayout.CENTER);
        PanelsController.addActionPanel(addTextFormat, "addTextFormat");
        
        add(addTreeFormat);
        add(addRectangleFormat);
        add(addTextFormat);
        add(titleBoxcenter);
        add(titleBoxleft);
        add(titleBoxright);
        add(titlePage);
    }
}
