import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MoveableRectangleApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the window and set its title
            JFrame frame = new JFrame("Moveable Rectangle");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Create a panel for drawing rectangles
            MoveableRectanglePanel panel = new MoveableRectanglePanel();
            frame.add(panel, BorderLayout.CENTER);
            
            // Create a panel for input fields and button
            JPanel inputPanel = new JPanel();
            JTextField widthField = new JTextField(5);
            JTextField heightField = new JTextField(5);
            JButton button = new JButton("Add Rectangle");
            
            // Add components to the input panel
            inputPanel.add(new JLabel("Width: "));
            inputPanel.add(widthField);
            inputPanel.add(new JLabel("Height: "));
            inputPanel.add(heightField);
            inputPanel.add(button);
            
            // Add action listener to the button
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String widthText = widthField.getText();
                    String heightText = heightField.getText();
                    try {
                        int width = Integer.parseInt(widthText);
                        int height = Integer.parseInt(heightText);
                        panel.addRectangle(width, height);
                        frame.repaint();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter valid numbers for width and height.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            
            // Add the input panel to the frame
            frame.add(inputPanel, BorderLayout.NORTH);
            
            // Set the size of the window and make it visible
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}

class MoveableRectanglePanel extends JPanel {
    private List<Rectangle> rectangles = new ArrayList<>();
    private Rectangle selectedRectangle;
    private Point mousePosition;

    public void addRectangle(int width, int height) {
        int x = (int) (Math.random() * (getWidth() - width));
        int y = (int) (Math.random() * (getHeight() - height));
        rectangles.add(new Rectangle(x, y, width, height));
        selectedRectangle = rectangles.get(rectangles.size() - 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw all rectangles
        g.setColor(Color.RED);
        for (Rectangle rect : rectangles) {
            g.fillRect(rect.x, rect.y, rect.width, rect.height);
        }
    }

    public MoveableRectanglePanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (Rectangle rect : rectangles) {
                    if (rect.contains(e.getPoint())) {
                        selectedRectangle = rect;
                        mousePosition = e.getPoint();
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedRectangle = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedRectangle != null) {
                    int deltaX = e.getX() - mousePosition.x;
                    int deltaY = e.getY() - mousePosition.y;
                    selectedRectangle.translate(deltaX, deltaY);
                    mousePosition = e.getPoint();
                    repaint();
                }
            }
        });
    }
}
