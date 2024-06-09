package ITETransTrees.View;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import ControllersUI.*;

public class HomePageTrans extends JFrame {
    DrawerUI drawerUI;
    public HomePageTrans() {
        initComponents();
    }
    private void initComponents() {
        setName("HomePageTrans");
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
        JLabel titleApp = LabelController.addLabel("ITE Trans Trees", FontController.getPrimaryFont(1, 38), 0, 50,1280, 50);
        JLabel titleBoxleft = LabelController.addLabel("Add Tree Generic", FontController.getPrimaryFont(1, 28), 450, 625,400, 50);
        JPanel treeGeneric=PanelsController.roundedBorder(60);
        JPanel exitP=new JPanel();
        exitP.setBounds(1220, 0, 60, 60);
        exitP.setLayout(new BorderLayout());
        exitP.setOpaque(false);
        PanelsController.addActionPanel(exitP,"Exit");
        exitP.add(ImageController.addPhoto("exit.png", 60, 60),BorderLayout.CENTER);

        titleApp.setForeground(ColorController.getWhiteColor());
        titleBoxleft.setForeground(ColorController.getWhiteColor());
       
        HomePanel.setName("HomePageTrans");
        HomePanel.setBounds(0, 10, 1280, 700);
        HomePanel.setLayout(null);
        HomePanel.setOpaque(false);
        backgroundPanel.setLayout(null);
        drawerUI=new DrawerUI();

        treeGeneric.setName("treeGeneric");
        treeGeneric.setOpaque(false);
        treeGeneric.setBackground(Color.decode("#E7E7E7"));
        treeGeneric.setLayout(new BorderLayout());
        treeGeneric.setBounds(500, 150, 300, 450);
        treeGeneric.add(ImageController.addPhoto("treeGeneric.png",280,280),BorderLayout.CENTER);
        PanelsController.addActionPanel(treeGeneric, "treeGeneric");
        HomePanel.add(titleBoxleft);
        HomePanel.add(treeGeneric);
        
        HomePanel.add(titleApp);

        GenericTreeUI genericTreeUI=new GenericTreeUI();
        backgroundPanel.add(genericTreeUI);
        backgroundPanel.add(HomePanel);
        backgroundPanel.add(exitP);
        backgroundPanel.add(drawerUI);
        MainPanels.addPanel(HomePanel);
        MainPanels.addPanel(genericTreeUI);
        MainPanels.addPanel(drawerUI);
        add(backgroundPanel);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
        genericTreeUI.setVisible(false);
        drawerUI.setVisible(false);
    }
}
