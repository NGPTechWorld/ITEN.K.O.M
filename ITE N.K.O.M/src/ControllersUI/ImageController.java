package ControllersUI;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.io.File;


public class ImageController {

    static String imagesPath = "resources/images/";

    public static void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            //clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ImageIcon getITENodesOfTree(){
        String imagePath = imagesPath + "rectangel.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        return imageIcon;
    }
    public static ImageIcon getITETransTree(){
        String imagePath = imagesPath + "treeGeneric.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        return imageIcon;
    }
    public static ImageIcon getITEMain(){
        String imagePath = imagesPath + "addnodes.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        return imageIcon;
    }
    public static ImageIcon getIcon(String name){
        String imagePath = imagesPath + name;
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image resizedImage = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        return resizedImageIcon;
    }
    public static ImageIcon getIcon(String name,int width,int height){
        String imagePath = imagesPath + name;
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image resizedImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        return resizedImageIcon;
    }
    public static JLabel addPhoto(String name){
        String imagePath = imagesPath + name;
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image resizedImage = imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedImageIcon);
        return imageLabel;
    }
    public static JLabel addPhotoBasic(String name){
        String imagePath = imagesPath + name;
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(imageIcon);
        return imageLabel;
    }
    public static JLabel addPhoto(String name,int WIDTH,int HEIGHT){
        String imagePath = imagesPath + name;
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image resizedImage = imageIcon.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedImageIcon);
        return imageLabel;
    }
}
