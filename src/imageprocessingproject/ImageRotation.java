package imageprocessingproject;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author DASHRATH LAL
 */
public class ImageRotation {
    private final static int ROTATE_LEFT=1;
    private final static int ROTATE_RIGHT=2;
    private int width,height;
    private String title;
    private RescaleOp rescale;
    private ImageIcon icon;
    private AffineTransformOp op;
    private AffineTransform tx;
    public void Rotation(BufferedImage image,int direction){
        width=image.getWidth();height=image.getHeight();
        BufferedImage rotate=new BufferedImage(height,width,image.getType());
        for(int h=0;h<height;h++){
         for(int w=0;w<width;w++){
             switch(direction){
                 case ROTATE_LEFT:
                                   rotate.setRGB(h,(width-1)-w,image.getRGB(w, h));
                                   title="ROTATE_LEFT";
                                   break;
                 case ROTATE_RIGHT:
                                    rotate.setRGB((height-1)-h,w,image.getRGB(w, h));
                                    title="ROTATE_RIGHT";
                                    break;
                 default:
                                   JOptionPane.showMessageDialog(null,"you Enter wrong int value");
                                   exit(0);
             }}}
        ImageIcon icon=new ImageIcon(rotate);
        Image image1=icon.getImage();
        new ImageDisplay(image1,title);
    }
    public void Rotation(BufferedImage image,double degree){
        double angel=(((Math.PI)/180)*degree);
        width=image.getWidth();height=image.getHeight();
        tx = new AffineTransform();
        tx.rotate(angel,width,height);//(radian,arbit_X,arbit_Y)
        op = new AffineTransformOp(tx,AffineTransformOp.TYPE_BILINEAR);
        image=op.filter(image,null);//(sourse,destination)
        ImageIcon icon=new ImageIcon(image);
       new ImageDisplay(icon.getImage(),String.valueOf(degree));
    }
    public static void main(String args[]) throws IOException{
        ImageRotation r=new ImageRotation();
        File f=new File("E://image//1.jpg"); 
        BufferedImage img=ImageIO.read(f);
         r.Rotation(img,12.0);
    }
}
