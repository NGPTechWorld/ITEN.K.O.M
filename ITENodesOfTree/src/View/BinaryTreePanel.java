package View;

import java.awt.*;
import javax.swing.*;

import Controller.DataBase;
import Module.Node;

import Module.TreeRectangel;

public class BinaryTreePanel extends JPanel {
    int maxY=0,maxX=0;
    Node treeRec;
    public void updateTree(Node newRoot) {
        this.treeRec = newRoot;
        repaint(); 
    }
    public BinaryTreePanel() {
        this.treeRec = DataBase.rootRectangle;
        setPreferredSize(new Dimension(maxX+200,maxY+200));
        setLayout(new BorderLayout());
        this.setOpaque(false);
        //this.setBackground(Color.BLACK);
        setLayout(null);
        JPanel plur=new JPanel();
        plur.setOpaque(false);
        plur.setSize(2000, 500);
        add(plur,BorderLayout.CENTER);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, getWidth() / 2, 30, treeRec, getWidth() / 4);
        //drawTree(g, 600, 30, treeRec, 200);
    }

    private void drawTree(Graphics g, int x, int y, Node node, int xOffset) {
        if (node != null) {
            ((Graphics2D) g).setStroke(new BasicStroke(3));
            g.setColor(Color.WHITE);
            
            g.drawOval(x, y, 30, 30);
            g.drawString(String.valueOf(node.getValue()), x +10, y + 20);
    
            if (node.getLeftChild() != null) {
                int newX = x - xOffset;
                int newY = y + 50;
                maxX=Math.max(maxX, newX);
                maxY=Math.max(maxY, newY);
                g.drawLine(x + 15, y + 30, newX + 15, newY);
                drawTree(g, newX, newY, node.getLeftChild(), xOffset / 2);
            }
    
            if (node.getRightChild() != null) {
                int newX = x + xOffset;
                int newY = y + 50;
                maxX=Math.max(maxX, newX);
                maxY=Math.max(maxY, newY);
                g.drawLine(x + 15, y + 30, newX + 15, newY);
                drawTree(g, newX, newY, node.getRightChild(), xOffset / 2);
            }
        }
    }
    
}