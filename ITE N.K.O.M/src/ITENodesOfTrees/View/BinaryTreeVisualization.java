package ITENodesOfTrees.View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ControllersUI.DataBase;
import ITENodesOfTrees.Module.Node;

public class BinaryTreeVisualization extends JPanel {
    private Node root;
    private static final int NODE_RADIUS = 20;
    private static final int LEVEL_HEIGHT = 70;

    public BinaryTreeVisualization(Node root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        int treeDepth = getTreeDepth(root);
        int initialXOffset = (int) (getWidth() / Math.pow(2, treeDepth));
        drawTree(g2d, root, getWidth() / 2, 30, initialXOffset, treeDepth);
    }

    private void drawTree(Graphics2D g2d, Node node, int x, int y, int xOffset, int depth) {
        if (node == null) {
            return;
        }

        // Set color to white and draw the node
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, 2 * NODE_RADIUS, 2 * NODE_RADIUS);

        // Set color to black and draw the node outline
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, 2 * NODE_RADIUS, 2 * NODE_RADIUS);
        g2d.drawString(String.valueOf(node.value), x - 10, y + 5);

        // Calculate new xOffset for children
        int newOffset = xOffset / 2;

        // Draw the left subtree
        if (node.leftChild != null) {
            g2d.drawLine(x, y + NODE_RADIUS, x - newOffset, y + LEVEL_HEIGHT - NODE_RADIUS);
            drawTree(g2d, node.leftChild, x - newOffset, y + LEVEL_HEIGHT, 0, depth - 1);
        }

        // Draw the right subtree
        if (node.rightChild != null) {
            g2d.drawLine(x, y + NODE_RADIUS, x + newOffset, y + LEVEL_HEIGHT - NODE_RADIUS);
            drawTree(g2d, node.rightChild, x + newOffset, y + LEVEL_HEIGHT, 0, depth - 1);
        }
    }

    private int getTreeDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getTreeDepth(node.leftChild), getTreeDepth(node.rightChild));
    }

    public static void main() {
        JFrame frame = new JFrame("Binary Tree Visualization");
        BinaryTreeVisualization treePanel = new BinaryTreeVisualization(DataBase.rootRectangle);
        frame.add(treePanel);
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
