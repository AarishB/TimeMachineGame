import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Screen {
    public static ImageButton backArrow = new ImageButton(
            new ImageIcon(new ImageIcon("BackArrow.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
            0, 300, 100, 100, 1);
    public static ImageButton nextArrow = new ImageButton(
            new ImageIcon(new ImageIcon("NextArrow.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
            0, 300, 100, 100, 1);


    static int WIDTH;
    static int HEIGHT;
    public Color bg;
    public List<GameObject> objects;
    public boolean visible = true;

    public Screen() {
        objects = new ArrayList<>();
    }

    public void addGameObject(GameObject o) {
        objects.add(o);
    }

    public void draw(Graphics g, int px, int py) {
        if (!visible)
            return;
        g.setColor(bg);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        int n = objects.size();
        for (int i = 0; i < n; i++) {
            objects.get(i).draw(g, px, py);
        }
    }

    public boolean processClick(int mx, int my) {
        for (GameObject o : objects) {
            if (o instanceof Button btn && btn.isClicked(mx, my)) {
                btn.onClick();
                return true;
            }
        }
        return false;
    }

    public void setVisible(boolean vis) {
        visible = vis;
    }
}
