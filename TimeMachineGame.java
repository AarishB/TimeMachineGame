import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class TimeMachineGame extends JPanel {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT  = 600;
    
    private final BufferedImage image;
    private final Graphics g;
    private final Timer timer;

    public TimeMachineGame () {
        image = new BufferedImage   (FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();
        timer = new Timer(1000/60, new TimerListener());
        timer.start();
        addMouseListener(new Mouse());
        addMouseMotionListener(new MouseMotion());
        addKeyListener(new Keyboard());
        setFocusable(true);
        requestFocusInWindow();
    }
    private class MouseMotion implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {}
        
        @Override
        public void mouseMoved(MouseEvent e) {}
    }
    private class Keyboard implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            
        }
        
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    private class Mouse implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) { //avoid using for now, stick to mouseReleased i guess

        }
        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {} 

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    }
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            g.setColor(new Color(0, 255, 0));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            g.setColor(new Color(255, 0, 0));
            g.fillRect(100, 100, 100, 100);
            g.setColor(new Color(0, 0, 255));
            
            repaint();
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
    public static void main (String[] args) {
        JFrame frame = new JFrame  ("Time Machine Game");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0, 0);
        frame.setContentPane(new TimeMachineGame());
        frame.setVisible(true);
    }
}   