import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
        private int playerX = WIDTH / 2 - PLAYER_SIZE / 2;
        private int dodged = 0;
        private List<Rectangle> obstacles = new ArrayList<>();
        private Random rnd = new Random();
        

        GamePanel(){
            setBackground(Color.WHITE);
            setFocusable(true);
            addKeyListener(new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if(e.getKeyCode() == KeyEvent.VK_LEFT){
                        playerX = Math.max(0, playerX - 20);
                    } 
                    else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                        playerX = Math.min(WIDTH - PLAYER_SIZE, playerX + 20);
                    }
                }
            });
        }

        void spawn(){
            int x = rnd.nextInt(WIDTH - OBSTACLE_SIZE);
            obstacles.add(new Rectangle(x, 0, OBSTACLE_SIZE, OBSTACLE_SIZE));
        }

        void update(){
            Iterator<Rectangle> it = obstacles.iterator();
            while(it.hasNext()){
                Rectangle obs = it.next();
                obs.y += 5;
                Rectangle playerRect = new Rectangle(playerX, HEIGHT - PLAYER_SIZE, PLAYER_SIZE, PLAYER_SIZE);
                if(obs.intersects(playerRect)){
                    endGame(false);
                    return;
                }
                if(obs.y > HEIGHT){
                    it.remove();
                    dodged++;
                    if(dodged >= WIN_COUNT){
                        endGame(true);
                        return;
                    }
                }
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(playerX, HEIGHT - PLAYER_SIZE, PLAYER_SIZE, PLAYER_SIZE);
        g.setColor(Color.RED);
        for(Rectangle obs : obstacles){
            g.fillRect(obs.x, obs.y, obs.width, obs.height);
        }
        g.setColor(Color.BLACK);
        g.drawString("Dodged: " + dodged + "/" + WIN_COUNT, 10, 20);
    }

    private void endGame(boolean won){
        gameTimer.stop();
        spawnTimer.stop();
        
        JDialog dlg = new JDialog(frame, false);
        dlg.setUndecorated(true);
        dlg.add(new JLabel(won ? "You dodged them all!" : "Ouch - hit by a dino!"));
        dlg.pack();
        dlg.setLocationRelativeTo(panel);
        dlg.setVisible(true);

         new Timer(1500, ev -> {
                if (won) complete(); 
                frame.dispose();
            }).start();
        }

    }