package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import Module.Node;

public class BinaryTreeDrawer extends JPanel {
    private Node root;
    private Map<Node, Point> nodePositions;

    private static final int NODE_SIZE = 30;
    private static final int HORIZONTAL_SPACING = 50;
    private static final int VERTICAL_SPACING = 50;

    public BinaryTreeDrawer(Node root) {
        this.root = root;
        this.nodePositions = new HashMap<>();
        calculateNodePositions(root, 0, 0, HORIZONTAL_SPACING);
    }

    private void calculateNodePositions(Node node, int x, int y, int xOffset) {
        if (node == null) {
            return;
        }

        nodePositions.put(node, new Point(x, y));

        calculateNodePositions(node.leftChild, x - xOffset, y + VERTICAL_SPACING, xOffset / 2);
        calculateNodePositions(node.rightChild, x + xOffset, y + VERTICAL_SPACING, xOffset / 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, root);
    }

    private void drawTree(Graphics g, Node node) {
        if (node == null) {
            return;
        }

        Point position = nodePositions.get(node);

        g.setColor(Color.BLACK);
        g.fillOval(position.x, position.y, NODE_SIZE, NODE_SIZE);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(node.value), position.x + NODE_SIZE / 3, position.y + NODE_SIZE / 2);

        if (node.leftChild != null) {
            Point leftPosition = nodePositions.get(node.leftChild);
            g.drawLine(position.x + NODE_SIZE / 2, position.y + NODE_SIZE, leftPosition.x + NODE_SIZE / 2, leftPosition.y);
            drawTree(g, node.leftChild);
        }

        if (node.rightChild != null) {
            Point rightPosition = nodePositions.get(node.rightChild);
            g.drawLine(position.x + NODE_SIZE / 2, position.y + NODE_SIZE, rightPosition.x + NODE_SIZE / 2, rightPosition.y);
            drawTree(g, node.rightChild);
        }
    }

}