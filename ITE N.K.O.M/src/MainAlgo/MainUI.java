package MainAlgo;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

import ControllersUI.*;

public class MainUI extends JFrame {
    
    public MainUI() {
        initComponents();
    }

    private void initComponents() {
        setIconImage(ImageController.getITEMain().getImage());
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
        JLabel titleApp = LabelController.addLabel("ITE N.K.O.M Main", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
        JLabel titleBoxleft = LabelController.addLabel("ITE Nodes Of Trees", FontController.getPrimaryFont(1, 28), 160, 625,400, 50);
        JLabel titleBoxright = LabelController.addLabel("ITE Trans Trees", FontController.getPrimaryFont(1, 28), 750, 625,400, 50);
        JPanel treeGeneric=PanelsController.roundedBorder(60);
        JPanel treeBinary=PanelsController.roundedBorder(60);

        JPanel exitP=new JPanel();
        exitP.setBounds(1220, 0, 60, 60);
        exitP.setLayout(new BorderLayout());
        exitP.setOpaque(false);
        PanelsController.addActionPanel(exitP,"Exit");
        exitP.add(ImageController.addPhoto("exit.png", 60, 60),BorderLayout.CENTER);

        titleApp.setForeground(ColorController.getWhiteColor());
        titleBoxleft.setForeground(ColorController.getWhiteColor());
        titleBoxright.setForeground(ColorController.getWhiteColor());

        HomePanel.setName("HomeMain");
        HomePanel.setBounds(0, 10, 1280, 700);
        HomePanel.setLayout(null);
        HomePanel.setOpaque(false);
        backgroundPanel.setLayout(null);

        treeGeneric.setName("treeGeneric");
        treeGeneric.setOpaque(false);
        treeGeneric.setBackground(Color.decode("#E7E7E7"));
        treeGeneric.setLayout(new BorderLayout());
        treeGeneric.setBounds(150, 150, 1000, 200);
        treeGeneric.add(ImageController.addPhoto("ITENODESOFTREE.png",1000,200),BorderLayout.CENTER);
        PanelsController.addActionPanel(treeGeneric, "ITENODESOFTREE");
        HomePanel.add(treeGeneric);

        treeBinary.setName("treeBinary");
        treeBinary.setOpaque(false);
        treeBinary.setBackground(Color.decode("#E7E7E7"));
        treeBinary.setLayout(new BorderLayout());
        treeBinary.setBounds(150, 450, 1000, 200);
        treeBinary.add(ImageController.addPhoto("ITETRANSTREES.png",1000,200),BorderLayout.CENTER);
        PanelsController.addActionPanel(treeBinary, "ITETRANSTREES");
        HomePanel.add(treeBinary);
        HomePanel.add(titleApp);
        backgroundPanel.add(HomePanel);
        backgroundPanel.add(exitP);
        MainPanels.addPanel(HomePanel);
        add(backgroundPanel);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
}
