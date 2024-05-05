// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class BinaryTreeApp extends JFrame {
//     private BinaryTree binaryTree;

//     public BinaryTreeApp() {
//         binaryTree = new BinaryTree();

//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setTitle("Binary Tree");
//         setSize(1280, 720);

//         JPanel panel = new JPanel();
//         panel.setLayout(new BorderLayout());

//         // عرض الشجرة
//         BinaryTreePanel treePanel = new BinaryTreePanel(binaryTree);
//         panel.add(treePanel, BorderLayout.CENTER);

//         // مربع الإدخال
//         JTextField nodeValueField = new JTextField(10);
//         panel.add(nodeValueField, BorderLayout.SOUTH);

//         // زر إضافة عقدة
//         JButton addButton = new JButton("Add Node");
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 try {
//                     int value = Integer.parseInt(nodeValueField.getText());
//                     binaryTree.addNode(value,value,value);
//                     treePanel.repaint();
//                 } catch (NumberFormatException ex) {
//                     JOptionPane.showMessageDialog(null, "Please enter a valid integer value.");
//                 }
//                 nodeValueField.setText("");
//             }
//         });
//         panel.add(addButton, BorderLayout.EAST);

//         add(panel);
//         setVisible(true);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(new Runnable() {
//             @Override
//             public void run() {
//                 new BinaryTreeApp();
//             }
//         });
//     }
// }

// class BinaryTreePanel extends JPanel {
//     private BinaryTree binaryTree;

//     public BinaryTreePanel(BinaryTree binaryTree) {
//         this.binaryTree = binaryTree;
//     }

//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         drawTree(g, getWidth() / 2, 30, binaryTree.getRoot(), getWidth() / 4);
//     }

//     private void drawTree(Graphics g, int x, int y, Node node, int xOffset) {
//         if (node != null) {
//             g.drawOval(x, y, 30, 30);
//             g.drawString(String.valueOf(node.getValue()), x + 10, y + 20);

//             if (node.getLeftChild() != null) {
//                 int newX = x - xOffset;
//                 int newY = y + 50;
//                 g.drawLine(x + 15, y + 30, newX + 15, newY);
//                 drawTree(g, newX, newY, node.getLeftChild(), xOffset / 2);
//             }

//             if (node.getRightChild() != null) {
//                 int newX = x + xOffset;
//                 int newY = y + 50;
//                 g.drawLine(x + 15, y + 30, newX + 15, newY);
//                 drawTree(g, newX, newY, node.getRightChild(), xOffset / 2);
//             }
//         }
//     }
// }

// class BinaryTree {
//     private Node root;

//     public BinaryTree() {
//         root = null;
//     }

//     public Node getRoot() {
//         return root;
//     }

//     public void addNode(int value,int width,int height) {
//         root = addNodeRecursive(root, value, width, height);
//     }

//     private Node addNodeRecursive(Node current, int value,int width,int height) {
//         if (current == null) {
//             return new Node(value, width, height);
//         }

//         if (value < current.getValue()) {
//             current.setLeftChild(addNodeRecursive(current.getLeftChild(), value, width, height));
//         } else if (value > current.getValue()) {
//             current.setRightChild(addNodeRecursive(current.getRightChild(), value, width, height));
//         }

//         return current;
//     }
// }

// class Node {
//     private int value;
//     private Node leftChild;
//     private Node rightChild;
//     int width,height;
//     public Node(int value,int width,int height) {
//         this.value = value;
//         leftChild = null;
//         rightChild = null;
//         this.height=height;
//         this.width=width;
//     }

//     public int getValue() {
//         return value;
//     }

//     public Node getLeftChild() {
//         return leftChild;
//     }

//     public Node getRightChild() {
//         return rightChild;
//     }

//     public void setLeftChild(Node leftChild) {
//         this.leftChild = leftChild;
//     }

//     public void setRightChild(Node rightChild) {
//         this.rightChild = rightChild;
//     }
// }
