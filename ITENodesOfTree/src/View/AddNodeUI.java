package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNodeUI extends JLabel {
    AddNodeUI() {
        initComponents();
    }

    private void initComponents() {
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
        nodeValueLabel.setHorizontalAlignment(0);
        nodeWidthLabel.setHorizontalAlignment(0);
        nodeHeightLabel.setHorizontalAlignment(0);

        // JButton addButton = new JButton("Add Node");
        // addButton.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // try {
        // int value = Integer.parseInt(nodeValueField.getText());
        // // binaryTree.addNode(value,value,value);
        // // treePanel.repaint();
        // } catch (NumberFormatException ex) {
        // JOptionPane.showMessageDialog(null, "Please enter a valid integer value.");
        // }
        // nodeValueField.setText("");
        // }
        // });
        // setBounds(1000, 0, 280, 720);
        setBackground(Color.DARK_GRAY);
        setSize(280, 720);
        setLayout(null);

        add(nodeValueField);
        add(nodeValueLabel);
        add(nodeWidthLabel);
        add(nodeWidthField);
        add(nodeHeightLabel);
        add(nodeHeightField);
        setVisible(true);
    }
}
