package View;

import java.awt.*;
import javax.swing.*;
import Controller.*;


public class OutputUI extends JPanel{
    public static JLabel iconExit;
    public OutputUI(){
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
        setName("OutputUI");
        setBounds(0, 500, 1280, 200);
        setLayout(null);
        setOpaque(true);
        setBackground(ColorController.getBlackColor());
        JLabel titlePage = LabelController.addLabel("Output", FontController.getPrimaryFont(1, 36), 0, 0,200, 50);
    
        JPanel treeFormat=PanelsController.roundedBorder(60);
        JPanel rectangleFormat=PanelsController.roundedBorder(60);
        JPanel textFormat=PanelsController.roundedBorder(60);

        titlePage.setForeground(ColorController.getWhiteColor());
       

        treeFormat.setName("ExportTreeFormat");
        treeFormat.setOpaque(false);
        treeFormat.setBackground(Color.decode("#E7E7E7"));
        treeFormat.setLayout(new BorderLayout());
        treeFormat.setBounds(900, 20, 160, 160);
        iconExit=ImageController.addPhoto("treeRectandle.png",120,120);
        treeFormat.add(iconExit,BorderLayout.CENTER);
        
        PanelsController.addActionPanel(treeFormat, "addTreeFormat");

        rectangleFormat.setName("EportRectangleFormat");
        rectangleFormat.setOpaque(false);
        rectangleFormat.setBackground(Color.decode("#E7E7E7"));
        rectangleFormat.setLayout(new BorderLayout());
        rectangleFormat.setBounds(300, 20, 160, 160);
        rectangleFormat.add(ImageController.addPhoto("rectangel.png",120,120),BorderLayout.CENTER);
        PanelsController.addActionOutput(rectangleFormat, "EportRectangleFormat");

        textFormat.setName("EportTextFormat");
        textFormat.setOpaque(false);
        textFormat.setBackground(Color.decode("#E7E7E7"));
        textFormat.setLayout(new BorderLayout());
        textFormat.setBounds(600, 20, 160, 160);
        textFormat.add(ImageController.addPhoto("textRectangle.png",120,120),BorderLayout.CENTER);
        PanelsController.addActionPanel(textFormat, "addTextFormat");
        
        add(treeFormat);
        add(rectangleFormat);
        add(textFormat);
        add(titlePage);
    }
}
