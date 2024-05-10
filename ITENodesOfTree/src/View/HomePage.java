package View;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import Controller.*;
import Module.MainPanels;
public class HomePage extends JFrame {
    public HomePage() {
        initComponents();
    }

    private void initComponents() {
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        // ---------BackGround-----------------
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = ColorController.firstColor();
                Color color2 = ColorController.secoundColor();
                GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setLayout(null);
        // ------------------------------------ 
        JPanel HomePanel=new JPanel();
        JLabel titleApp = LabelController.addLabel("ITE Nodes Of Tree", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
        JLabel titleBoxleft = LabelController.addLabel("Add Rectangle Complete", FontController.getPrimaryFont(1, 28), 160, 625,400, 50);
        JLabel titleBoxright = LabelController.addLabel("Add List Rectangles", FontController.getPrimaryFont(1, 28), 750, 625,400, 50);
        JPanel addRectangelFill=PanelsController.roundedBorder(60);
        JPanel addRectangeNodes=PanelsController.roundedBorder(60);

        JPanel exitP=new JPanel();
        exitP.setBounds(1220, 0, 60, 60);
        exitP.setLayout(new BorderLayout());
        exitP.setOpaque(false);
        PanelsController.addActionPanel(exitP,"Exit");
        exitP.add(ImageController.addPhoto("exit.png", 60, 60),BorderLayout.CENTER);

        titleApp.setForeground(ColorController.getWhiteColor());
        titleBoxleft.setForeground(ColorController.getWhiteColor());
        titleBoxright.setForeground(ColorController.getWhiteColor());

        HomePanel.setName("Home");
        HomePanel.setBounds(0, 10, 1280, 700);
        HomePanel.setLayout(null);
        HomePanel.setOpaque(false);
        backgroundPanel.setLayout(null);

        addRectangelFill.setName("addRectangelFill");
        addRectangelFill.setOpaque(false);
        addRectangelFill.setBackground(Color.decode("#E7E7E7"));
        addRectangelFill.setLayout(new BorderLayout());
        addRectangelFill.setBounds(200, 150, 300, 450);
        addRectangelFill.add(ImageController.addPhoto("addtreefill.png",270,405),BorderLayout.CENTER);
        PanelsController.addActionPanel(addRectangelFill, "RectangelComplete");
        HomePanel.add(titleBoxleft);
        HomePanel.add(addRectangelFill);

        addRectangeNodes.setName("addRectangelFill");
        addRectangeNodes.setOpaque(false);
        addRectangeNodes.setBackground(Color.decode("#E7E7E7"));
        addRectangeNodes.setLayout(new BorderLayout());
        addRectangeNodes.setBounds(800, 150, 300, 450);
        addRectangeNodes.add(ImageController.addPhoto("addnodes.png",294,441),BorderLayout.CENTER);
        PanelsController.addActionPanel(addRectangeNodes, "RecNode");
        HomePanel.add(titleBoxright);
        HomePanel.add(addRectangeNodes);
        HomePanel.add(titleApp);
        
        JPanel RectangelCompleteP=new RectangleComplete();
        backgroundPanel.add(RectangelCompleteP);
        backgroundPanel.add(HomePanel);
        backgroundPanel.add(exitP);
        MainPanels.addPanel(HomePanel);
        MainPanels.addPanel(RectangelCompleteP);
        RectangelCompleteP.setVisible(false);

        add(backgroundPanel);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
}
