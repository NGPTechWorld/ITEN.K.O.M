import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPanel;

public class TreePanel extends JPanel{
    TreePanel(){
        initComponents();
    }
    private void initComponents(){
        setSize(1000, 720);
        setLayout(null);
        //setBackground(Color.LIGHT_GRAY); 
    }
    public void paint(Graphics g){
        super.paint(g);
        Insets insets=getInsets();
        int top=insets.top;
        int left=insets.left;
        g.setColor(Color.orange);
        g.fillOval(left+475, top+10, 50, 50);
        for (int i = 1; i < 3; i++) {
            int n=(int)Math.pow(2,i );
            System.out.println(n);
            int p=500-(100*(n/2));
            for (int j = 0; j <n ; j++) {
                g.fillOval(left+p+(j*(200)), top+10+(i*100), 50, 50);
            }
            
            //g.fillOval(top+475-(i*100), left+10+(i*100), 50, 50);
        }
    }
}
