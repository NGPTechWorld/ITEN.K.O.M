package ITETransTrees.View;


import javax.swing.*;

import ITETransTrees.Module.NodeGeneric;

import java.awt.*;



public class GeneralTreeDrawer1 extends JFrame {

//    private final TreeNode root;
    private final NodeGeneric root;
    private final int offset=500;  //the distance between siblings

    public GeneralTreeDrawer1(NodeGeneric root) {
        this.root = root;
        initUI();
    }

    private void initUI() {
        setTitle("General Tree");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Button b1=new Button("Click");
        b1.setBounds(380,100,100,100);


        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                drawTree(g, root, maxWidth(root,1280/2,20,100)/3 , 20, offset);  //  ,x the distance between the root and left border of panel  ,y the distance between the root the north border of panel,offset the distance between two nodes

            }
        };
       panel.add(b1,BorderLayout.NORTH);

//        add(b1);


        panel.setPreferredSize(new Dimension(maxWidth(root,1280/2,20,offset), maxDepth(root,20))); // Set preferr

        // Set up the JScrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel); // Adjust



        add(scrollPane); // Add the JScrollPane to the JFrame instead of the JPanel directly
        scrollPane.setViewportView(panel);
        getContentPane().add(scrollPane, BorderLayout.CENTER); // Add t
//        pack();
        setLocationRelativeTo(null); // Center the window
    }

    //Calculate maxDepth
    static int maxDepth=0;
    int maxDepth(NodeGeneric node,  int y){
        int childY = y + 150;
        for (int i = 0; i < node.child.size(); i++){
            maxDepth( node.child.get(i) ,childY);
            if (maxDepth<childY){
                maxDepth=childY;
            }
        }
        return maxDepth+(maxDepth/6);
    }




    static int minValue=-1;
    static int maxValue=+1;
    private int maxWidth( NodeGeneric node, int x, int y, int offset) {

        int childY = y + 150; //  Distance between parent and child
        int childXOffset = offset ; //  space between siblings

        for (int i = 0; i < node.child.size(); i++) {
            int childX = x - childXOffset * (node.child.size() - 1) + 2 * i * childXOffset;
            maxWidth( node.child.get(i), childX, childY, childXOffset);
//            System.out.println("offsite "+offset);
//            System.out.println("childx "+childX);
//            System.out.println("childxoffsite "+childXOffset);
            if (childX<minValue){
                minValue=childX;
            }
            if (childX>maxValue){
                maxValue=childX;
            }

            System.out.println();
        }
//        System.out.println("maxValue +"+ maxValue+"\nminValue "+minValue);
//        System.out.println(maxValue +Math.abs(minValue));
        int sum=maxValue+Math.abs(minValue);
        return sum +(sum/6);
    }






    private void drawTree(Graphics g, NodeGeneric node, int x, int y, int offset) {

        Graphics2D g2d= (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);


        Font font=  new Font("Arial",Font.BOLD,20) ;
        g2d.setFont(font);

        //draw an Oval
//        g2d.drawOval(200,200,100,100);
//        g2d.drawString("Hello",225,255);
//


        int circleWidth=40*node.value.length();
        g2d.drawOval(x, y,circleWidth, 30);  // draw node  // x,y for position , width height for the circle
        g2d.drawString(node.value, x + circleWidth/3, y + 20);  // draw node // x,y for the string position


        int childY = y + 150; //  Distance between parent and child
        int childXOffset = offset/2 ; //  space between siblings
//        System.out.println(childY);


for (int i = 0; i < node.child.size(); i++) {
    int childX = x - childXOffset * (node.child.size() - 1) + 2 * i * childXOffset;
    g2d.drawLine(x+circleWidth/2, y + 30, childX+ circleWidth/2, childY);  //x1,y1 starting point  || x2,y2 ending point
//            System.out.println("First" +i +" "+node.value);
    drawTree(g2d, node.child.get(i), childX, childY, childXOffset);
//            System.out.println("offsite "+offset);
//            System.out.println("childx "+childX+ " childY "+childY);
//            System.out.println("childxoffsite "+childXOffset);
//            System.out.println(childX);
//            System.out.println(i);
    
}
}}
