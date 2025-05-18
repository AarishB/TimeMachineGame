import java.awt.*;
import javax.swing.ImageIcon;
public class ImageButton extends Button{
    public ImageIcon image;
    public int targetScreen;

    public ImageButton(ImageIcon icon, int x, int y, int w, int h, int targetScreen) {
        super(Color.BLACK, x, y, w, h, targetScreen);
        image = icon;
    }

    @Override
    public void draw(Graphics g, int px, int py) {
        px = 0;
        py = 0;
        if (!visible) return;
        int x = objx - px;
        int y = objy - py;
        g.drawImage(image.getImage(), x, y, width, height, null);
    }

}