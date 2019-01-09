package imageprocessingproject;
import java.awt.HeadlessException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
/**
 *
 * @author DASHRATH LAL
 */
public class ImageDownload {
    private static URL url;
    private static InputStream input;
    private  static FileOutputStream output;
    private static String path;
public  void download(String ImageLink,String ImageSavePath){
    try{
          String urltext=ImageLink;
          url=new URL(urltext);
         URLConnection urlconnection=url.openConnection();
         HttpURLConnection connection=null;
         byte buffer[]=new byte[1024];
         if(urlconnection instanceof HttpURLConnection){
             connection=(HttpURLConnection) urlconnection;
             input=connection.getInputStream();
             output=new FileOutputStream(ImageSavePath);
             int size=connection.getContentLength();
             int lenght=input.read();
             while(lenght!=-1){
                 System.out.println(lenght);
                 output.write(lenght);
                 lenght=input.read();
             }
             output.close();
             input.close();
             System.out.println("Downloading complete..................");
             path=ImageSavePath;
         }
         else{
               System.out.println("Enter right url...");
         }
      }
      catch(MalformedURLException e){System.out.println(e);} 
      catch(IOException e){}
  }
public  void InfoImg(String ImageLink) throws MalformedURLException{
        try{
                 String urltext=ImageLink;
                  url=new URL(urltext);
                 String details="URL is:"+url.toString()+"\n";
                   details+="Protocol is:"+url.getProtocol()+"\n";
                   details+="authority is:"+url.getAuthority()+"\n";
                   details+="file name is:"+url.getFile()+"\n";
                   details+="host is:"+url.getHost()+"\n";
                   details+="path is:"+url.getPath()+"\n";
                   details+="port is:"+url.getPort()+"\n";
                   details+="default port is:"+url.getDefaultPort()+"\n";
                   details+="query is:"+url.getQuery()+"\n";
                   details+="ref is:"+url.getRef()+"\n";
                   details+="Location is"+path+"\n";
                  JOptionPane.showMessageDialog(null,details);
        }
        catch(HeadlessException e){System.out.println(e);}
}
  public static void main(String str[]) throws MalformedURLException{
    ImageDownload obj=new ImageDownload();
   obj.download("https://vignette.wikia.nocookie.net/fantendo/images/6/6e/Small-mario.png/revision/latest?cb=20120718024112.jpg", "E://image//new.jpg");
   obj.InfoImg("https://vignette.wikia.nocookie.net/fantendo/images/6/6e/Small-mario.png/revision/latest?cb=20120718024112.jpg");
  }
}
