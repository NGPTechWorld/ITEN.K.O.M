package Controller;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



import Module.MainPanels;
import Module.RoundedPanel;

public class PanelsController {
    public static JPanel roundedBorder(int n) {
        return new RoundedPanel(n);
    }
    public static void switchPanels(String name) {
        for (JPanel p : MainPanels.Panels) {
            if (p.getName().equals(name)) {
                p.setVisible(true);
            } else {
                p.setVisible(false);
            }
        }
    }
    public static void addActionPanel (JPanel panel,String action){
        MouseListener ms = new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                switch (action) {
                    
                    default:
                        //switchPanels(action);
                        break;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                panel.setBackground(ColorController.getWhiteColor());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                panel.setBackground(Color.decode("#EEEEEE"));
            }
        };
        panel.addMouseListener(ms);

    } 
}
