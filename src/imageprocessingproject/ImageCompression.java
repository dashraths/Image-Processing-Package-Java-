package imageprocessingproject;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
/**
 *
 * @author DASHRATH LAL
 */
public class ImageCompression {
   public void Compress(String ImagePath,String SaveImagePath,float compressquality){
       try{
       String ex[]=ImagePath.split("[.]");
       File file = new File(ImagePath);
      BufferedImage image = ImageIO.read(file);
      File newfile = new File(SaveImagePath);
      OutputStream os =new FileOutputStream(newfile);
      Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName(ex[1]);
      ImageWriter writer = (ImageWriter) writers.next();
      ImageOutputStream ios = ImageIO.createImageOutputStream(os);
      writer.setOutput(ios);
      ImageWriteParam param = writer.getDefaultWriteParam();
      param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
      param.setCompressionQuality(compressquality);
      writer.write(null, new IIOImage(image, null, null), param);
      os.close();
      ios.close();
      writer.dispose();
     }
     catch(IOException e){}}
     public static void main(String args[]){
         ImageCompression obj=new ImageCompression();
         obj.Compress("E://image//1.jpg","E://image//output.jpg",.2f);
     }
   }
