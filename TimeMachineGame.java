import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.swing.*;


public class TimeMachineGame extends JPanel {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;

    private final BufferedImage image;
    private final Graphics g;
    private final Timer timer;

    static int activeScreen;

    static ArrayList<Screen> screens = new ArrayList<>();
    ArrayList<Integer> keysPressed;
    Player player = new Player(0, 0, 5, null);

    public TimeMachineGame() {
        image = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();
        timer = new Timer(1000 / 60, new TimerListener());
        timer.start();
        addMouseListener(new Mouse());
        addMouseMotionListener(new MouseMotion());
        addKeyListener(new Keyboard());
        setFocusable(true);
        requestFocusInWindow();
        Screen.WIDTH = FRAME_WIDTH;
        Screen.HEIGHT = FRAME_HEIGHT;
        keysPressed = new ArrayList<>();
        screens.add(new IntroScreen());
        screens.add(new EraScreen());
        screens.add(new JurassicScreen());
        screens.add(new RobotEra());
        screens.add(new BossScreen());
        screens.add(new TestScreen());
        activeScreen = 0;
        changeScreen(activeScreen);
        System.out.println("Screens loaded: " + screens.size());  // should print 5

    }

    private class MouseMotion implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    private class Keyboard implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (!keysPressed.contains(e.getKeyCode())) {
                keysPressed.add(e.getKeyCode());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (keysPressed.contains(e.getKeyCode())) {
                keysPressed.remove(Integer.valueOf(e.getKeyCode()));
            }
        }
    }

    private class Mouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) { //avoid using for now, stick to mouseReleased i guess is buggy type shi

        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            screens.get(activeScreen).processClick(e.getX(), e.getY());
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public void processKeysPressed() {
        for (int key : keysPressed) {
            switch (key) {
                case KeyEvent.VK_UP -> player.moveUp();
                case KeyEvent.VK_DOWN -> player.moveDown();
                case KeyEvent.VK_LEFT -> player.moveLeft();
                case KeyEvent.VK_RIGHT -> player.moveRight();
            }
        }
    }

    public static void changeScreen(int newScreen){
        activeScreen = newScreen;
        for(Screen s : screens){
            s.visible = false;
        }
        screens.get(newScreen).visible = true;
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            processKeysPressed();
            for(Screen s : screens){
                s.draw(g, player.getX(), player.getY());
            }
            //introScreen.draw(g, player.getX(), player.getY());
            //System.out.println(player.getX() + ", " + player.getY());
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Time Machine Game");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0, 0);
        frame.setContentPane(new TimeMachineGame());
        frame.setVisible(true);
    }
}
