import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class JurassicScreen extends Screen {
    private static final int EGG_X = 650;
    private static final int EGG_Y = 75;
    private static final int BUBBLE_W = 100;
    private static final int BUBBLE_H = 60;
    private static final int PADDING = 20;

    public JurassicScreen(){
        super();
        bg = Color.cyan; 
        ImageIcon raw = new ImageIcon("JurassicScreen.png");
        Image img = raw.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
        objects.add(new ImageObject(new ImageIcon(img), 0, 0, WIDTH, HEIGHT));
        objects.add(new Button(Color.ORANGE, 200, 200, 150, 80, 0) {
            @Override
            public void onClick() {
                new FossilFinder("jurassic_fact.png") {
                    @Override
                    protected void complete() {
                        super.complete();
                        int bubbleX = EGG_X - (BUBBLE_W/2);
                        int bubbleY = EGG_Y - BUBBLE_H - PADDING;
                        JurassicScreen.this.objects.add(new ImageObject(new ImageIcon("dinofact2.png"), bubbleX, bubbleY, BUBBLE_W, BUBBLE_H));
                    }
                }.start();
            }
        });
        objects.add(new Button(Color.GREEN, 50, 50, 100, 100, 3)); 
        objects.add(new Button(Color.red, 500, 500, 100, 100, 1));
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
        // g.setColor(Color.MAGENTA);
        // g.fillOval(EGG_X - 5, EGG_Y - 5, 10, 10);
    }
}
