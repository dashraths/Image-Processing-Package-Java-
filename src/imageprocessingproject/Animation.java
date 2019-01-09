package imageprocessingproject;
import java.util.Random;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class Animation{
    public void TextAnimation(String planetext){
      JFrame frame=new JFrame();
     JLabel lblText,lblText1;
     frame.setTitle("Text Animation");
     frame.setLayout(null);
     lblText=new JLabel("<html><p style='color: #ff00ff; font-size:20pt'>"+planetext+"</p></html>");
     lblText1=new JLabel("<html><p style='color:red; font-size:20pt'>"+planetext+"</p></html>");
     lblText.setSize(200,50);
     lblText1.setSize(200,50);
     frame.setSize(500,300);
     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
     frame.add(lblText);frame.add(lblText1);
     frame.setVisible(true);
     int x=1;
          int y=5;
          try{
              while(x<500){
                     lblText.setLocation(x,y);
                     lblText1.setLocation(x+30,y+30);
                    Thread.sleep(10);
                    x+=20;
                    y+=20;
                    if(x>500) x=1;
                    if(y>300) y=5;
 
                    } 
   
           }catch(InterruptedException ie){System.out.println("Interrupted...");}
       }
     public void MoveImage(String ImagePath){
         JFrame frame=new JFrame();
          frame.setVisible(true);
          frame.setSize(800, 500);
          frame.setLayout(null);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          ImageIcon icon1=new ImageIcon("b3.jpg");
         frame.setContentPane(new JLabel(new ImageIcon(icon1.getImage())));
         ImageIcon icon=new ImageIcon(ImagePath);
         JLabel label=new JLabel();
         label.setBounds(0,0,300,300);
         label.setIcon(icon);
         frame.add(label);
         int x=1;
          int y=5;
          try{
              while(x<800){
                     label.setLocation(x,y);
                      Thread.sleep(100);
                    x+=2;
                    y+=20;
                    if(x>800) x=1;
                    if(y>500) y=5;
 
                    }
           
   
           }catch(InterruptedException ie){System.out.println("Interrupted...");}
       }
     public void MoveImageRec(String ImagePath) throws InterruptedException{
         int dim = 50;int x = 7, y = 7;int dx = 3, dy = 5;int delay = 40;
         JFrame frame=new JFrame();
          frame.setVisible(true);
          frame.setSize(800, 500);
          frame.setLayout(null);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          ImageIcon icon1=new ImageIcon("b3.jpg");
         frame.setContentPane(new JLabel(new ImageIcon(icon1.getImage())));
         ImageIcon icon=new ImageIcon(ImagePath);
         JLabel label=new JLabel();
         JLabel label1=new JLabel();
         label.setBounds(0,0,300,300);
         label1.setBounds(0, 0,300,300);
         label.setIcon(icon);label1.setIcon(icon);
         frame.add(label);frame.add(label1);
         Random r=new Random();
         
           while(true){
               int X=r.nextInt(600);
               int Y=r.nextInt(300);
               Thread.sleep(250);
              // System.out.println(X+"  "+Y);
               label.setLocation(X, Y);
                // bounce
            if(x + dim >600 || x < 0)
                dx = -dx;
            if(y + dim >300 || y < 0){
                dy = -dy;}
               
            x += dx;
            y += dy;
            label1.setLocation(x-20, y-100);
            try{
                Thread.sleep(10);}
            catch(InterruptedException e){}}  
     }
    public static void main(String args[]) throws InterruptedException{
        Animation obj=new Animation();
       obj.MoveImageRec("E://image//1.jpg");
    }
}
