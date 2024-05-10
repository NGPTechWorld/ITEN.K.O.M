package Controller;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



import Module.MainPanels;
import Module.RoundedPanel;
import View.RectangleComplete;

public class PanelsController {
    public static JPanel roundedBorder(int n) {
        return new RoundedPanel(n);
    }
    public static String backPanel="";
    public static void switchPanels(String name,String now) {
        for (JPanel p : MainPanels.Panels) {
            if (p.getName().equals(name)) {
                p.setVisible(true);
                backPanel=now;
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
                    case "RectangelComplete":
                        switchPanels("RectangleComplete","Home");
                    break;
                    case "Exit":
                        System.exit(0);
                    break;
                    case "back":
                        switchPanels(backPanel,"");
                        System.out.println(backPanel);
                    break;
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
                if(action=="Exit"){
                    
                }else{
                    panel.setBackground(ColorController.getWhiteColor());
                }
                
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if(action=="Exit"){

                }else{
                    panel.setBackground(Color.decode("#E7E7E7"));
                }
            }
        };
        panel.addMouseListener(ms);

    } 
}
