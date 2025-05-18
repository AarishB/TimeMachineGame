import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class IntroScreen extends Screen {
    public IntroScreen(){
    super();
        bg = Color.darkGray;
        // objects.add(new ImageObject(new ImageIcon("IntroScreen.png"), 0, 0, WIDTH, HEIGHT));
        ImageIcon raw = new ImageIcon("IntroScreen.png");
        Image img = raw.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
        objects.add(new ImageObject(new ImageIcon(img), 0, 0, WIDTH, HEIGHT));
        objects.add(new ImageButton(
            new ImageIcon(new ImageIcon("enterbutton.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
            700, 300, 100, 100,1));
       // objects.add(new Box(Color.BLUE, 100, 100, 100, 100));
    }
    public void draw(Graphics g, int px, int py){
        if(!visible) return;
        g.setColor(bg);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        int n = objects.size();
        for(int i = 0; i < n; i++){
            objects.get(i).draw(g, 0, 0);
        }
    }
}
