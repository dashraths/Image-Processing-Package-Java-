package imageprocessingproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.net.URL;
/**
 *
 * @author DASHRATH LAL
 */
public class RAnimation extends JApplet {
    DemoAnimationCanvas canvas;
    JButton startButton, stopButton;
    URL codeBase;      
    @Override
    public void init() {
        Container container = getContentPane();
        canvas = new DemoAnimationCanvas();
        container.add(canvas);
        startButton = new JButton("Start Animation");
        startButton.addActionListener(new ButtonListener());
        stopButton  = new JButton("Stop Animation");
        stopButton.addActionListener(new ButtonListener());
        JPanel panel = new JPanel();
        panel.add(startButton); panel.add(stopButton);
        container.add(BorderLayout.SOUTH, panel);
    }
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton temp = (JButton) e.getSource();
            if (temp.equals(startButton)) {
                canvas.start();                          
            }
            else if (temp.equals(stopButton)) {
                canvas.stop();
            }}}}
class DemoAnimationCanvas extends JPanel implements Runnable {
    Thread thread;
    Image image;
    BufferedImage bi;
    double x, y, xi, yi; 
    int rotate;
    double scale; int UP = 0; int DOWN = 1;
    int scaleDirection;
    DemoAnimationCanvas(){
        setBackground(Color.BLACK);
        ImageIcon icon3=new ImageIcon("E://image//1.jpg");
        image = icon3.getImage();
        MediaTracker mt = new MediaTracker( this );
        mt.addImage(image, 1);
        try {
            mt.waitForAll();
        } catch (InterruptedException e) {}
        rotate = (int) (Math.random() * 360);
        scale = Math.random() * 1.5;
        scaleDirection = DOWN;
        xi = 50.0; yi = 50.0;
    }
    public void step( int w, int h ) {
        x += xi; y += yi;
        // the x and y exceed the dimensions of canvas
        if (x > w) {
            x = w - 1;
            xi = Math.random() * -w/32;
        }
        if (x < 0) {
            x = 2;
            xi =  Math.random() * w/32;
        }
        if (y > h) {
            y = h - 2;
            yi = Math.random() * -h/32;
        }
        if (y < 0) {
            y = 2;
            yi = Math.random() * h/32;
        }

        // upgrade the rotation coordinates

        if ((rotate += 5) == 360) {
            rotate = 0;
        }

        // upgrade the scaling coordinates depending on the
        // increase or decrease in size. If the increase in size
        // exceeds a limit of 1.5, decrease the size. If the
        // decrease in size falls below 0.5, increase the size.

        if (scaleDirection == UP) {

            if ((scale += 0.5) > 1.5) {
                scaleDirection = DOWN;
            }

        }

        // upgrade the scaling coordinates

        else if (scaleDirection == DOWN) {
            if ((scale -= .05) < 0.5) {
                scaleDirection = UP;
            }
        }
    }
  
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension d = getSize();
        bi = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D big =  bi.createGraphics();
        step(d.width, d.height);
        AffineTransform at = new AffineTransform();
        at.setToIdentity();
        at.translate(x, y);
        at.rotate(Math.toRadians(rotate));
        at.scale(scale, scale);
        big.drawImage(image, at, this);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bi, 0 , 0, null);
        big.dispose();
    }

    // Starts the thread

    public void start() {
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }

    // Stops the thread

    public void stop() {
        if (thread != null)
            thread.interrupt();
        thread = null;
    }

    // Runs the thread

    @Override
    public void run() {
        Thread me = Thread.currentThread();
        while (thread == me) {
            repaint();
        }
        thread = null;
    }
}
