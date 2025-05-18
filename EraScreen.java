import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class EraScreen extends Screen {
    public EraScreen(){
        super();
        bg = Color.cyan;
       // System.out.println(new File("EraScreen.png").exists());
       ImageIcon raw = new ImageIcon("EraScreen.png");
       Image img = raw.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
        objects.add(new ImageObject(new ImageIcon(img), 0, 0, WIDTH, HEIGHT));
        
       objects.add(new ImageButton(
            new ImageIcon(new ImageIcon("NextArrow.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
            700, 175, 100, 100, 2));
       objects.add(new ImageButton(
            new ImageIcon(new ImageIcon("NextArrow.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
            700, 300, 100, 100, 3));
        objects.add(new ImageButton(
        new ImageIcon(new ImageIcon("NextArrow.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
        700, 425, 100, 100, 4));


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
