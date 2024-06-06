package ITENodesOfTrees.View;

import javax.swing.*;
import ControllersUI.DataBase;
import ControllersUI.FontController;
import ITENodesOfTrees.Module.Node;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Map;

public class TreePanel extends JPanel {
    Node tree;
    double zoomFactor = 1.0;
    int nodeRadius = 20;
    int verticalSpacing = 50;
    int horizontalSpacing = 20;
    Map<Node, Point> nodeLocations;

    public TreePanel() {
        this.tree = DataBase.rootRectangle;
        setOpaque(false);
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getPreciseWheelRotation() < 0) {
                    zoomFactor *= 1.1;
                } else {
                    zoomFactor /= 1.1;
                }
                revalidate();
                repaint();
            }
        });
    }

    public void updateTree(Node newRoot) {
        this.tree = newRoot;
        repaint();
        System.out.println(this.getWidth());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform originalTransform = g2d.getTransform();
        g2d.scale(zoomFactor, zoomFactor);

        nodeLocations = new HashMap<>();
        int totalTreeWidth = getSubtreeWidth(tree);
        calculateNodeLocations(tree, getWidth() / 2, 50, nodeLocations, totalTreeWidth / 2);
        drawTree(g2d, tree);

        g2d.setTransform(originalTransform);
    }

    private void calculateNodeLocations(Node node, int x, int y, Map<Node, Point> nodeLocations, int offsetX) {
        if (node == null) {
            return;
        }

        nodeLocations.put(node, new Point(x, y));

        int leftWidth = getSubtreeWidth(node.leftChild);
        int rightWidth = getSubtreeWidth(node.rightChild);
        int maxSubtreeWidth = Math.max(leftWidth, rightWidth) + horizontalSpacing;

        if (node.leftChild != null) {
            calculateNodeLocations(node.leftChild, x - maxSubtreeWidth / 2, y + verticalSpacing, nodeLocations, maxSubtreeWidth / 2);
        }
        if (node.rightChild != null) {
            calculateNodeLocations(node.rightChild, x + maxSubtreeWidth / 2, y + verticalSpacing, nodeLocations, maxSubtreeWidth / 2);
        }
    }

    private int getSubtreeWidth(Node node) {
        if (node == null) {
            return 0;
        }
        int leftWidth = getSubtreeWidth(node.leftChild);
        int rightWidth = getSubtreeWidth(node.rightChild);
        return leftWidth + rightWidth + nodeRadius * 2 + horizontalSpacing;
    }

    private void drawTree(Graphics2D g2d, Node node) {
        if (node == null) {
            return;
        }

        Point point = nodeLocations.get(node);
        int x = point.x;
        int y = point.y;

        g2d.setColor(Color.WHITE);
        g2d.fillOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
        g2d.setColor(Color.BLACK);
        g2d.setFont(FontController.getPrimaryFont(1, 18));
        g2d.drawString(node.value, x - 6, y + 4);

        if (node.leftChild != null) {
            Point leftPoint = nodeLocations.get(node.leftChild);
            g2d.setColor(Color.WHITE);
            g2d.drawLine(x, y, leftPoint.x, leftPoint.y);
            drawTree(g2d, node.leftChild);
        }

        if (node.rightChild != null) {
            Point rightPoint = nodeLocations.get(node.rightChild);
            g2d.setColor(Color.WHITE);
            g2d.drawLine(x, y, rightPoint.x, rightPoint.y);
            drawTree(g2d, node.rightChild);
        }
    }
}
