package imageprocessingproject;
/**
 *
 * @author DASHRATH LAL
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
public class ImageConverter{
      File file=null,file1=null;
      BufferedImage image=null;
      BufferedImage imag1=null;
      String str[]=null;
      String ex="";
      static int TO_PNG=1;//PNG stands for Portable Network Graphics
      static int TO_JPG=2;//JPEG stands for Joint Photographic Experts Group
      static int TO_GIF=3;//GIF stands for Graphic Interchange Format
      static int TO_BMP=4;//Bitmap image file
      
    public  void Conversion(String ImagePath,int type,String SaveImagePath){
        
        try{
              str=ImagePath.split("[.]");
             file=new File(ImagePath);
             image=ImageIO.read(file);
             switch(type){
                 
                 case 1:
                                SaveImagePath+=".png";
                                ex="png";
                                 break;
                 case 2:
                               SaveImagePath+=".jpg";
                                ex="jpg";
                                 break;
                 case 3:
                               SaveImagePath+=".gif";
                               ex="gif";
                                 break;
                 case 4:
                               SaveImagePath+=".bmp";
                               ex="bmp";
                                 break;
                 default :
                             JOptionPane.showMessageDialog(null, "ERROR......!");
                 
             }
             try{
                 file=new File(SaveImagePath);
                 ImageIO.write(image,ex, file);
             }
             catch(IOException e){}
        }
        catch(IOException e){System.out.println("File not found....");}
        JOptionPane.showMessageDialog(null, "change successful !..."+ str[1] +" TO "+ ex );
    }
    public static void main(String[] args) {
       ImageConverter obj=new ImageConverter();
       obj.Conversion("E://image//1.jpg", ImageConverter.TO_BMP,"E://image//j1u");
    }
}
