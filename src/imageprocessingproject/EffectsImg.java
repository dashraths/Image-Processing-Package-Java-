package imageprocessingproject;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author DASHRATH LAL
 */
//interface EffectMethod
interface EffectMethod{
     void ImageGrey(String ImagePath);
     void SaveImg(String ImagePath,BufferedImage obj);
     void ImageSepia(String ImagePath);//no
     void ImageGreen(String ImagePath);
     void ImageRed(String ImagePath);
     void ImageBlue(String ImagePath);
     void ImageNeg(String ImagePath);
     void ImageRandomPI(String ImagePath);
     void ImageMirror(String ImagePath);
}
public class EffectsImg implements EffectMethod{
    int width,height;
    File file,save;
    BufferedImage image,image1;
    ImageIcon icon;
    Image im;
    public EffectsImg(){}
    
    
    
    @Override
    public void ImageGrey(String ImagePath) {
        image=null;icon=null;im=null;file=null;width=height=0;
        ImageDisplay img=new ImageDisplay(ImagePath,"original");//initial state of image display
        width=img.getWidth();
        height=img.getHeight();
        try{
            file=new File(ImagePath);
            image=ImageIO.read(file);}
        catch(IOException e){JOptionPane.showMessageDialog(null, "Image Path Found");}
        //convert to grayscale
        //Get pixel value and extract ARGB value
    for(int y = 0; y < height; y++){
         for(int x = 0; x < width; x++){
            int p = image.getRGB(x,y);//get pixel value
            int a = (p>>24) & 0xff;     //get alpha a
            int r = (p>>16) & 0xff;     //get red   r
            int g = (p>>8) & 0xff;      //get green g
            int b = p & 0xff;           //get blue b
        //calculate average
            int avg = (r+g+b)/3;
        //replace RGB value with avg
            p = (a<<24) | (avg<<16) | (avg<<8) | avg<<0;
            image.setRGB(x, y, p);
      }}
        //Display image
       icon=new ImageIcon(image);
       im=icon.getImage();
       img.displayImage(im,"Grey");
    }
    
    
    
    @Override
    public void SaveImg(String ImagePath,BufferedImage image) {
        try{
           File save=new File(ImagePath);
            ImageIO.write(image,"jpg", save);
            JOptionPane.showMessageDialog(null, "Image save successfully");
        }
        catch(IOException e){JOptionPane.showMessageDialog(null, "path not found");}
    }
    
    
    
    @Override
    public void ImageSepia(String ImagePath) {
        image=null;icon=null;im=null;file=null;width=height=0;
        ImageDisplay img=new ImageDisplay(ImagePath,"original");//initial state of image display
        width=img.getWidth();
        height=img.getHeight();
        try{
            file=new File(ImagePath);
            image=ImageIO.read(file);}
        catch(IOException e){JOptionPane.showMessageDialog(null, "Image Path Found");}
    for(int y = 0; y < height; y++){
         for(int x = 0; x < width; x++){
            int p = image.getRGB(x,y);
            int a = (p>>24)&0xff;     
            int r = (p>>16)&0xff;     
            int g = (p>>8)&0xff;      
            int b = p&0xff;
       //calculate tr, tg, tb  (transformation between two color)
        int tr = (int)(0.393*r + 0.769*g + 0.189*b);
        int tg = (int)(0.349*r + 0.686*g + 0.168*b);
        int tb = (int)(0.272*r + 0.534*g + 0.131*b);
        //check condition
        if(tr > 255){
          r = 255;
        }else{
          r = tr;
        }
        if(tg > 255){
          g = 255;
        }else{
          g = tg;
        }
        if(tb > 255){
          b = 255;
        }else{
          b = tb;
        }
        //set new RGB value
        p = (a<<24) | (r<<16) | (g<<8) | b;
        image.setRGB(x, y, p);   
         }
       }
      //Display image
       icon=new ImageIcon(image);
       im=icon.getImage();
       img.displayImage(im,"Sepia");
    }
    @Override
    public void ImageGreen(String ImagePath) {
            image=null;icon=null;im=null;file=null;width=height=0;
            ImageDisplay img=new ImageDisplay(ImagePath,"original");
            width=img.getWidth();
            height=img.getHeight();
        try{
            file=new File(ImagePath);
            image=ImageIO.read(file);}
        catch(IOException e){JOptionPane.showMessageDialog(null, "Path not found");}
       for(int y=0;y<height;y++){
          for(int x=0;x<width;x++){
              int p=image.getRGB(x, y);
              int a=(p>>24)&0xff;
              int g=(p>>8)&0xff;
              //set new RGB
              p = ((a<<24)|(0<<16)|(g<<8)|0);
             image.setRGB(x, y, p);
          }
       }
       //Display image
       icon=new ImageIcon(image);
       im=icon.getImage();
       img.displayImage(im,"Green");
    }

    @Override
    public void ImageRed(String ImagePath) {
       image=null;icon=null;im=null;file=null;width=height=0;
            ImageDisplay img=new ImageDisplay(ImagePath,"original");
            width=img.getWidth();
            height=img.getHeight();
        try{
            file=new File(ImagePath);
            image=ImageIO.read(file);}
        catch(IOException e){JOptionPane.showMessageDialog(null, "Path not found");}
       for(int y=0;y<height;y++){
          for(int x=0;x<width;x++){
              int p=image.getRGB(x, y);
              int a=(p>>24)&0xff;
              int r=(p>>16)&0xff;
              //set new RGB
              p = ((a<<24) | (0<<8) | (r<<16) | 0);
             image.setRGB(x, y, p);
          }
       }
       //Display image
       icon=new ImageIcon(image);
       im=icon.getImage();
       img.displayImage(im,"Red");
    }

    @Override
    public void ImageBlue(String ImagePath) {
        image=null;icon=null;im=null;file=null;width=height=0;
            ImageDisplay img=new ImageDisplay(ImagePath,"original");
            width=img.getWidth();
            height=img.getHeight();
        try{
            file=new File(ImagePath);
            image=ImageIO.read(file);}
        catch(IOException e){JOptionPane.showMessageDialog(null, "Path not found");}
       for(int y=0;y<height;y++){
          for(int x=0;x<width;x++){
              int p=image.getRGB(x, y);
              int a=(p>>24)&0xff;
              int b=p&0xff;
              //set new RGB
              p = ((a<<24)|(0<<16)|(0<<8)|b);
             image.setRGB(x, y, p);
          }
       }
       //Display image
       icon=new ImageIcon(image);
       im=icon.getImage();
       img.displayImage(im,"BLUE");
    }
   
    
    
    @Override
    public void ImageNeg(String ImagePath) {
      image=null;icon=null;im=null;file=null;width=height=0;
      ImageDisplay img=new ImageDisplay(ImagePath,"original");
      width=img.getWidth();height=img.getHeight();
      try{
          file=new File(ImagePath);
          image=ImageIO.read(file);} 
          catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "path not found");}
      for(int y=0;y<height;y++){
        for(int x=0;x<width;x++){
            int p=image.getRGB(x, y);
            //int a=(p>>24)&0xff;
            int r=(p>>16)&0xff;
            int g=(p>>8)&0xff;
            int b=p&0xff;
            //subtract RGB from 255
            r=(255-r);
            g=(255-g);
            b=(255-b);
            p=(p<<24)|(r<<16)|(g<<8)|b;
            image.setRGB(x, y, p);
        }
      }
      //Display image
       icon=new ImageIcon(image);
       im=icon.getImage();
       img.displayImage(im,"Negative");
    }
    @Override
    public void ImageRandomPI(String ImagePath){
        image=null;icon=null;im=null;file=null;width=height=0;
        ImageDisplay img=new ImageDisplay(ImagePath,"original");
        width=img.getWidth();
        height=img.getHeight();
        try{
        file=new File(ImagePath);
        image=ImageIO.read(file);}
        catch(IOException e){JOptionPane.showMessageDialog(null, "Path not Found");}
        for(int y=0;y<height;y++){
          for(int x=0;x<width;x++){
             int a=(int)(Math.random()*256);//alpha
             int r=(int)(Math.random()*256);//red
             int g=(int)(Math.random()*256);//green
             int b=(int)(Math.random()*256);//blue
             int p=(a<<24)|(r<<16)|(g<<8)|b;
             image.setRGB(x, y, p);
          }
        }
        //Display image
       icon=new ImageIcon(image);
       im=icon.getImage();
       img.displayImage(im,"random image pixel");
    }
    @Override
    public void ImageMirror(String ImagePath) {
       image=null;icon=null;im=null;file=null;width=height=0;image1=null;
       ImageDisplay img=new ImageDisplay(ImagePath,"Original");
       width=img.getWidth();
       height=img.getHeight();
       try{
           file=new File(ImagePath);
           image=ImageIO.read(file);
       }
       catch(IOException e){JOptionPane.showMessageDialog(null, "Image Path not found");}
       image1=new BufferedImage(width*2,height,BufferedImage.TYPE_INT_ARGB);
       for(int y=0;y<height;y++){
         for(int lx=0,rx=2*width-1;lx<width;lx++,rx--){
             int p=image.getRGB(lx, y);
             image1.setRGB(lx, y, p);
             image1.setRGB(rx, y, p);
         }
       }
       //Display image
       icon=new ImageIcon(image1);
       im=icon.getImage();
       img.displayImage(im, "Mirror");
    }
    public static void main(String args[]) throws IOException{
        EffectsImg img=new EffectsImg();
        img.ImageRandomPI("E://image//1.jpg");
        // ImageDisplay obj=new ImageDisplay();
       // ImageDisplay obj1=new ImageDisplay("E://image//4.jpg","");
       // obj.displayImage("E://image//3.jpg", "display");
        
    }
}