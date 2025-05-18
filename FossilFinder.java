import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class FossilFinder extends Minigame{
    private ImageIcon fossilIcon;
    private int digs = 0;
    private final int REQUIRED_DIGS = 20;
    private final int GRID_SIZE = 5;
    private boolean[][] fossilGrid;
    private JButton[][] buttons;

    public FossilFinder(String factReward){
        super("Fossil Finder", "Dig for fossils by clicking the grid!", factReward);
        fossilIcon = new ImageIcon("fossil.png");
        fossilGrid = new boolean[GRID_SIZE][GRID_SIZE];
        buttons = new JButton[GRID_SIZE][GRID_SIZE];
        Random random = new Random();

        fossilGrid[random.nextInt(GRID_SIZE)][random.nextInt(GRID_SIZE)] = true;
    }

    @Override
    public void start(){
        frame = new JFrame(getName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                JButton button = new JButton();
                int r = row;
                int c = col;
                button.addActionListener(e -> dig(r, c, button));
                buttons[row][col] = button;
                frame.add(button);
            }
        }

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void dig(int row, int col, JButton button){
        if(fossilGrid[row][col]){
            button.setIcon(fossilIcon);
            button.setText("");
            complete();
        }
        else{
            button.setBackground(Color.DARK_GRAY);
            digs++;
            button.setEnabled(false);
            if(digs >= REQUIRED_DIGS){
                JOptionPane.showMessageDialog(frame, "YOu ran out of digs! Try again.");
                frame.dispose();
            }
        }
    }
    private void showPopup (String message, JButton button) {
        Point p = button.getLocationOnScreen();
        JWindow popup = new JWindow(frame);
        popup.getContentPane().add(new JLabel(message));
        popup.pack();
        popup.setLocation(p.x, p.y - popup.getHeight() - 5);
        popup.setVisible(true);
        new Timer(1500, e -> popup.dispose()).start();
    }
}