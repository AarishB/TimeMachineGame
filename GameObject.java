import java.awt.*;
import java.awt.image.*;

public abstract class GameObject {
    public int objx;
    public int objy;
    public boolean visible = true;

    public GameObject() {
    }

    public GameObject(int x, int y) {
        this.objx = x;
        this.objy = y;
    }

    public void update() {
    }

    public abstract void draw(Graphics g, int px, int py);

    public boolean isOnScreen(int screenWidth, int screenHeight) {
        return visible;
    }
}