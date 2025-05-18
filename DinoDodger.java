import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DinoDodger extends Minigame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int PLAYER_SIZE = 40;
    private static final int OBSTACLE_SIZE = 30;
    private static final int OBSTACLE_DELAY = 1000;
    private static final int WIN_COUNT = 10;

    private JFrame frame;
    private GamePanel panel;
    private Timer gameTimer;
    private Timer spawnTimer;

    public DinoDodger(String factReward){
        super("Dino Dodger", "Use <- -> to dodge falling dinos!", factReward);
    }

    @Override
    public void start(){
        frame = new JFrame(getName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new GamePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gameTimer = new Timer(33, e -> panel.update());
        gameTimer.start();
        spawnTimer = new Timer(OBSTACLE_DELAY, e -> panel.spawn());
        spawnTimer.start();   
    }

    private class GamePanel extends JPanel{
        private int playerX = 
    }
}