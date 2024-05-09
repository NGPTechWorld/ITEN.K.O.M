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
        JLabel titleApp = LabelController.addLabel("ITE Nodes Of Tree", FontController.getPrimaryFont(1, 38), 0, 50,
                1280, 50);
        titleApp.setForeground(ColorController.getWhiteColor());
        add(titleApp);
        backgroundPanel.setLayout(null);
        JPanel addRectangelFill=PanelsController.roundedBorder(60);
        addRectangelFill.setName("addRectangelFill");
        addRectangelFill.setOpaque(false);
        addRectangelFill.setBounds(200, 150, 300, 450);
        MainPanels.addPanel(addRectangelFill);
        backgroundPanel.add(addRectangelFill);

        JPanel addRectangeNodes=PanelsController.roundedBorder(60);
        addRectangeNodes.setName("addRectangelFill");
        addRectangeNodes.setOpaque(false);
        addRectangeNodes.setBounds(800, 150, 300, 450);
        MainPanels.addPanel(addRectangeNodes);
        backgroundPanel.add(addRectangeNodes);
        add(backgroundPanel);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
}
