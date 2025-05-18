import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class TestScreen extends Screen {
    public TestScreen() {
        super();
        // light gray background
        bg = Color.LIGHT_GRAY;

        // full-screen test background (optional)
        objects.add(new ImageObject(new ImageIcon("IntroScreen.png"), 0, 0, WIDTH, HEIGHT));
        

        // orange button at (50,50) to launch FossilFinder
        objects.add(new Button(Color.ORANGE, 50, 50, 150, 100, 0) {
            @Override
            public void onClick() {
                // start the FossilFinder minigame
                new FossilFinder("jurassic_fact.png").start();
            }
        });
    }

    @Override
    public void draw(Graphics g, int px, int py) {
        if (!visible) return;
        // fill background
        g.setColor(bg);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // draw all objects
        for (GameObject obj : objects) {
            obj.draw(g, px, py);
        }
    }
}
