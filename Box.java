import java.awt.*;

public class Box extends GameObject{
    public Color color;
    public int width;
    public int height;

    public Box(Color c, int x, int y, int w, int h){
        objx = x;
        objy = y;
        width = w;
        height = h;
        color = c;
    }
    @Override
    public void draw(Graphics g, int px, int py) {
        if(!visible) return;
        int x = objx - px;
        int y = objy - py;
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
}
