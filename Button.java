import java.awt.*;
public class Button extends GameObject {
    public Color color;
    public int width;
    public int height;
    public int targetScreen;
    

    public Button(Color c, int x, int y, int w, int h, int targetScreen) {
        objx = x;
        objy = y;
        width = w;
        height = h;
        color = c;
        this.targetScreen = targetScreen;
    }
    

    @Override
    public void draw(Graphics g, int px, int py) {
        px = 0;
        py = 0;
        if (!visible) return;
        int x = objx - px;
        int y = objy - py;
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public boolean isClicked(int mx, int my) {
        return visible && mx >= objx && mx <= objx + width && my >= objy && my <= objy + height;
    }

    public void onClick() {
        TimeMachineGame.changeScreen(targetScreen);
    }
}