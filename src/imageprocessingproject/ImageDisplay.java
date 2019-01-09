package imageprocessingproject;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author DASHRATH LAL
 */
interface ImageMethod{
     void displayImage(String ImagePath,String TitleName);
     void displayImage(Image obj,String TitleName);
     void displayImage(Image obj,String TitleName,int width,int height);
     void displayImage(String ImagePath,String TitleName,int width,int height);
     int getHeight();
     int getWidth();
}
public class ImageDisplay implements ImageMethod{
    private File file;
    private BufferedImage image;
    private JFrame frame;
    private JLabel label;
    private ImageIcon icon;
    private int height,width;
    public ImageDisplay(String ImagePath,String TitleName){
        try{
            file=new File(ImagePath);
            image=ImageIO.read(file);
            height=image.getHeight();
            width=image.getWidth();
            frame=new JFrame(TitleName);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setSize(image.getWidth(), image.getHeight());
            label=new JLabel();
            label.setBounds(0, 0, image.getWidth(), image.getHeight());
            icon=new ImageIcon(image);
            label.setIcon(icon);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(HeadlessException | IOException e){JOptionPane.showMessageDialog(null, "ImagePathNotFound");}
     }
    public ImageDisplay(Image obj,String TitleName){
            frame=new JFrame(TitleName);
            frame.setLayout(null);
            frame.setVisible(true);
            height=obj.getHeight(null);
            width=obj.getWidth(null);
            frame.setSize(obj.getWidth(null),obj.getHeight(null));
            label=new JLabel();
            label.setBounds(0, 0, obj.getWidth(null), obj.getHeight(null));
            icon=new ImageIcon(obj);
            label.setIcon(icon);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public ImageDisplay(){}
    @Override
    public void displayImage(String ImagePath,String TitleName) {
        try{
            file=new File(ImagePath);
            image=ImageIO.read(file);
            height=image.getHeight();
            width=image.getWidth();
            frame=new JFrame(TitleName);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setSize(image.getWidth(), image.getHeight());
            label=new JLabel();
            label.setBounds(0, 0, image.getWidth(), image.getHeight());
            icon=new ImageIcon(image);
            label.setIcon(icon);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(IOException e){JOptionPane.showMessageDialog(null, "ImagePath not found");}
    }
    @Override
    public void displayImage(Image obj,String TitleName) {
            frame=new JFrame(TitleName);
            frame.setLayout(null);
            frame.setVisible(true);
            height=obj.getHeight(null);
            width=obj.getWidth(null);
            frame.setSize(obj.getWidth(null),obj.getHeight(null));
            label=new JLabel();
            label.setBounds(0, 0, obj.getWidth(null), obj.getHeight(null));
            icon=new ImageIcon(obj);
            label.setIcon(icon);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void displayImage(Image obj, String TitleName, int imgwidth, int imgheight) {
            frame=new JFrame(TitleName);
            frame.setLayout(null);
            frame.setVisible(true);
            height=obj.getHeight(null);
            width=obj.getWidth(null);
            frame.setSize(imgwidth,imgheight);
            label=new JLabel();
            label.setBounds(0,0,imgwidth,imgheight);
            icon=new ImageIcon(obj);
            label.setIcon(icon);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    @Override
    public void displayImage(String ImagePath, String TitleName, int imgwidth, int imgheight) {
        try{
            file=new File(ImagePath);
            image=ImageIO.read(file);
            height=image.getHeight();
            width=image.getWidth();
            frame=new JFrame(TitleName);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setSize(imgwidth,imgheight);
            label=new JLabel();
            label.setBounds(0, 0,imgwidth,imgheight);
            icon=new ImageIcon(image);
            label.setIcon(icon);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(IOException e){JOptionPane.showMessageDialog(null, "ImagePath not found");}
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public int getWidth() {
        return width;
    }
   public static void main(String args[]) throws IOException{
       ImageDisplay obj=new  ImageDisplay("E://image//1.jpg","icon");
      // ImageIcon icon=new ImageIcon("E://image//4.jpg");
      // obj.displayImage(icon, "");
       
    }
}