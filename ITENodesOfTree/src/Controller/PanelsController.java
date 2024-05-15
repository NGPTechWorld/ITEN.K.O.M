package Controller;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import Module.MainPanels;
import Module.Node;
import Module.RoundedPanel;
import View.RectangleComplete;
import View.RectangleFormatInput;
import View.TextFormatInput;

public class PanelsController {
    public static JPanel roundedBorder(int n) {
        return new RoundedPanel(n);
    }
    public static JPanel addBtnPanle(int x,int y,String name,Color color){
        JPanel btn=PanelsController.roundedBorder(40);
        btn.setBounds(x, y, 200, 50);
        btn.setOpaque(false);
        JLabel titlebtn = LabelController.addLabel(name, FontController.getPrimaryFont(1, 20), 0, 0,200, 50);
        titlebtn.setForeground(color);
        btn.setLayout(new BorderLayout());
        btn.add(titlebtn,BorderLayout.CENTER);
        return btn;
    }
    public static String backPanel="",preBackPanel="",nowPanel="Home";
    public static void switchPanels(String name,String now,String old) {
        for (JPanel p : MainPanels.Panels) {
            if (p.getName().equals(name)) {
                p.setVisible(true);
                nowPanel=name;
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
                        switchPanels("RectangleComplete","Home","");
                    break;
                    case "Exit":
                        System.exit(0);
                    break;
                    case"addTextFormat":
                        switchPanels("TextFormatInput", "RectangleComplete","Home");
                    break;
                    case"addRectangleFormat":
                        switchPanels("RectangleFormatInput", "RectangleComplete", "Home");
                    break;
                    case "EportRectangleFormat":
                        if(nowPanel=="TextFormatInput"){
                            TextFormatController.Import(action);
                        }
                    break;
                    case "back":
                        switchPanels(backPanel,"Home",preBackPanel);
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
    public static void addActionOutput (JPanel panel,String action){
        MouseListener ms = new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println(nowPanel);
                switch (action) {
                    case "CheckText":
                        try {
                            TextFormatController.Import(TextFormatInput.inpuTextField.getText());
                            TextFormatInput.stateCheck.setText("Done!");
                            TextFormatInput.stateCheck.setVisible(true);
                            TextFormatInput.outputUI.setVisible(true);
                            ImageController.playSound("resources\\images\\ngp.wav");
                        } catch (Exception i) {
                            TextFormatInput.stateCheck.setText("Error input!!");
                            TextFormatInput.outputUI.setVisible(false);
                            TextFormatInput.stateCheck.setVisible(true);
                        }
                    break;
                    case "OpenFile":
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.edit(DataBase.inputFile);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    break;
                    case "CheckFile":
                        try {
                            //RectangleFormatController.Import(RectangleFormatController.readFileToArray(), DataBase.rootRectangle);
                            String[] s=RectangleFormatController.readFileToStringArray();
                            RectangleFormatController.Import(s);
                            Node.dfs(DataBase.rootRectangle);
                            RectangleFormatInput.stateCheck.setText("Done!");
                            RectangleFormatInput.inpuTextField.setText(TextFormatController.export(DataBase.rootRectangle));
                            // RectangleFormatInput.inpuTextField.setText();
                            RectangleFormatInput.stateCheck.setVisible(true);
                            RectangleFormatInput.outputUI.setVisible(true);
                        } catch (Exception i) {
                            RectangleFormatInput.stateCheck.setText("Error input!!");
                            RectangleFormatInput.outputUI.setVisible(false);
                            RectangleFormatInput.stateCheck.setVisible(true);
                        }
                        
                        
                    break;
                    case "Clear":
                        TextFormatInput.inpuTextField.setText("");
                        TextFormatInput.outputUI.setVisible(false);
                        TextFormatInput.stateCheck.setVisible(false);
                        try {
                            DataBase.resetDataBase();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    break;
                    case "EportRectangleFormat":
                        if(nowPanel=="TextFormatInput"){
                            //System.out.println("Done");
                            RectangleFormatController.Export(DataBase.rootRectangle);
                        }
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
