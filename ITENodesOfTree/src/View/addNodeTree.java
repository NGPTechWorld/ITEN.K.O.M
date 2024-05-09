package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.TextFormatController;
import Module.Node;
import Module.TreeRectangel;

public class addNodeTree extends JFrame {
    TreeRectangel treeRec;

    addNodeTree() {
        treeRec = new TreeRectangel();
        treeRec.root = new Node("--");
        treeRec.root.leftChild = new Node("|");
        treeRec.root.leftChild.rightChild = new Node("B", 20, 30);
        treeRec.root.leftChild.leftChild = new Node("A", 30, 40);
        treeRec.root.rightChild = new Node("C", 50, 20);
        System.out.println(TextFormatController.export(treeRec.getRoot()));
        initComponents();
    }

    private void initComponents() {
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        setUndecorated(true);
        setLocationRelativeTo(null);

        JPanel menu = new JPanel();
        JLabel nodeValueLabel = new JLabel("Enter Value Node:");
        JLabel nodeWidthLabel = new JLabel("Enter Width Node:");
        JLabel nodeHeightLabel = new JLabel("Enter Height Node:");
        JTextField nodeValueField = new JTextField(10);
        JTextField nodeWidthField = new JTextField(10);
        JTextField nodeHeightField = new JTextField(10);
        nodeValueField.setBounds(10, 150, 260, 50);
        nodeValueLabel.setBounds(10, 100, 260, 50);
        nodeWidthLabel.setBounds(10, 230, 260, 50);
        nodeWidthField.setBounds(10, 280, 260, 50);
        nodeHeightLabel.setBounds(10, 360, 260, 50);
        nodeHeightField.setBounds(10, 410, 260, 50);

        nodeValueLabel.setForeground(Color.LIGHT_GRAY);
        nodeWidthLabel.setForeground(Color.LIGHT_GRAY);
        nodeHeightLabel.setForeground(Color.LIGHT_GRAY);

        nodeValueLabel.setFont(new Font("Tajawal", 1, 24));
        nodeWidthLabel.setFont(new Font("Tajawal", 1, 24));
        nodeHeightLabel.setFont(new Font("Tajawal", 1, 24));
        nodeValueField.setFont(new Font("Tajawal", 1, 20));
        nodeWidthField.setFont(new Font("Tajawal", 1, 20));
        nodeHeightField.setFont(new Font("Tajawal", 1, 20));

        nodeValueLabel.setHorizontalAlignment(0);
        nodeWidthLabel.setHorizontalAlignment(0);
        nodeHeightLabel.setHorizontalAlignment(0);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        // System.out.println(treeRec.getRoot().getValue());
        BinaryTreePanel binaryTreePanel = new BinaryTreePanel(treeRec);

        panel.setBounds(0, 0, 1000, 720);
        JButton addButton = new JButton("Add Node");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String value = (nodeValueField.getText());
                    int width = Integer.parseInt(nodeWidthField.getText());
                    int height = Integer.parseInt(nodeHeightField.getText());
                    /// reeRec.addNode(value,width,height); Add node
                    binaryTreePanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer value.");
                }
                nodeValueField.setText("");
                nodeWidthField.setText("");
                nodeHeightField.setText("");
            }
        });
        addButton.setBounds(40, 510, 200, 50);
        addButton.setBackground(Color.LIGHT_GRAY);

        menu.setBackground(Color.DARK_GRAY);
        menu.setBounds(1000, 0, 280, 720);
        menu.setSize(280, 720);
        menu.setLayout(null);
        menu.add(addButton);
        menu.add(nodeValueField);
        menu.add(nodeValueLabel);
        menu.add(nodeWidthLabel);
        menu.add(nodeWidthField);
        menu.add(nodeHeightLabel);
        menu.add(nodeHeightField);
        menu.setVisible(true);

        // binaryTreePanel.setBackground(Color.BLACK);
        setLayout(null);
        add(menu);
        panel.add(binaryTreePanel);
        panel.setBackground(Color.BLACK);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new addNodeTree();
    }
}
