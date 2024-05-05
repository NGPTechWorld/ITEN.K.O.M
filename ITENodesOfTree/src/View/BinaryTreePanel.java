package View;

import java.awt.Graphics;

import javax.swing.JPanel;

import Module.Node;

import Module.TreeRectangel;

class BinaryTreePanel extends JPanel {
    TreeRectangel treeRec;

    public BinaryTreePanel(TreeRectangel treeRec) {
        this.treeRec = treeRec;
        // System.out.println(treeRec.getRoot().getValue());
        setSize(1000, 720);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, getWidth() / 2, 30, treeRec.getRoot(), getWidth() / 4);
    }

    private void drawTree(Graphics g, int x, int y, Node node, int xOffset) {
        if (node != null) {
            g.drawOval(x, y, 30, 30);
            g.drawString(String.valueOf(node.getValue()), x + 40, y + 20);

            if (node.getLeftChild() != null) {
                int newX = x - xOffset;
                int newY = y + 50;
                g.drawLine(x + 15, y + 30, newX + 15, newY);
                drawTree(g, newX, newY, node.getLeftChild(), xOffset / 2);
            }

            if (node.getRightChild() != null) {
                int newX = x + xOffset;
                int newY = y + 50;
                g.drawLine(x + 15, y + 30, newX + 15, newY);
                drawTree(g, newX, newY, node.getRightChild(), xOffset / 2);
            }
        }
    }
}