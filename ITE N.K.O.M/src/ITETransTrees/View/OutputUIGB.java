package ITETransTrees.View;
import java.awt.*;
import javax.swing.*;

import ControllersUI.*;


public class OutputUIGB extends JPanel{
    public static JLabel iconExit;
    public OutputUIGB(){
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
        setName("OutputUIGB");
        setBounds(0, 500, 1280, 200);
        setLayout(null);
        setOpaque(true);
        setBackground(ColorController.getBlackColor());
        JLabel titlePage = LabelController.addLabel("Output", FontController.getPrimaryFont(1, 36), 0, 0,200, 50);
    
        JPanel genericFormat=PanelsController.roundedBorder(60);
        JPanel binaryFormat=PanelsController.roundedBorder(60);

        titlePage.setForeground(ColorController.getWhiteColor());
       
        genericFormat.setName("EportGenericFormat");
        genericFormat.setOpaque(false);
        genericFormat.setBackground(Color.decode("#E7E7E7"));
        genericFormat.setLayout(new BorderLayout());
        genericFormat.setBounds(400, 20, 160, 160);
        genericFormat.add(ImageController.addPhoto("treeGeneric.png",120,120),BorderLayout.CENTER);
        PanelsController.addActionOutput(genericFormat, "EportGenericFormat");

        binaryFormat.setName("EportBinaryFormat");
        binaryFormat.setOpaque(false);
        binaryFormat.setBackground(Color.decode("#E7E7E7"));
        binaryFormat.setLayout(new BorderLayout());
        binaryFormat.setBounds(800, 20, 160, 160);
        binaryFormat.add(ImageController.addPhoto("treeBinary.png",120,120),BorderLayout.CENTER);
        PanelsController.addActionOutput(binaryFormat, "EportBinaryFormat");
        
        add(genericFormat);
        add(binaryFormat);
        add(titlePage);
    }
}
