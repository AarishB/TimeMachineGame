import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ImageObject extends GameObject{
    public int width;
    public int height;
    public ImageIcon image;

    public ImageObject(ImageIcon i, int x, int y, int w, int h){
        image = i;
        objx = x;
        objy = y;
        width = w;
        height = h;
    }
    @Override
    public void draw(Graphics g, int px, int py) {
        if(!visible) return;
        int x = objx - px;
        int y = objy - py;
        g.drawImage(image.getImage(), x, y, null);
    }
    
}
