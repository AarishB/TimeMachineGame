import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class BossScreen extends Screen {
    private static final int W = WIDTH;
    private static final int H = HEIGHT;

    private static final int BUBBLE_W = 300;
    private static final int BUBBLE_H = 120;

    private static final int CHECK_W = 120;
    private static final int CHECK_H = 60;
    private final Button checkButton;

    private static final int QW = 300;
    private static final int QH = 120;

    private static final int ACW = 120;
    private static final int ACH = 80;
    private static final int PADDING = 20;

    private final BossFight fight;
    private final ImageObject readyPrompt;
    private int factsCollected = Integer.MAX_VALUE;
    private static final int SPRITE_W = 200;
    private static final int SPRITE_H = 200;
    private static final int SPRITE_X = (W - SPRITE_W) /2;
    private static final int SPRITE_TARGET_Y = (H - SPRITE_H) / 2;
    private Image bossSpriteImg;
    private Image backgroundImg;
    private int bossSpriteY;
    private int frameCounter = 0;


    public BossScreen() {
        super();
        bg = Color.DARK_GRAY;
        ImageIcon rawBG = new ImageIcon("BossBackgroundScreen.png");
        backgroundImg = rawBG.getImage().getScaledInstance(W, H, Image.SCALE_SMOOTH);
        ImageIcon rawBoss = new ImageIcon("BossSprite.png");
        bossSpriteImg = rawBoss.getImage().getScaledInstance(SPRITE_W, SPRITE_H, Image.SCALE_SMOOTH);
        bossSpriteY = -SPRITE_H;

        List<String> questions = Arrays.asList("dinoquestion1.png");
        List<List<String>> choices = Arrays
                .asList(Arrays.asList("dq1ac1.png", "dq1ac2.png", "dq1ac3.png", "dq1ac4.png"));

        fight = new BossFight(6, questions, choices);

        ImageIcon rawReady = new ImageIcon("AreYouReady.png");
        Image readyImg = rawReady.getImage().getScaledInstance(BUBBLE_W, BUBBLE_H, Image.SCALE_SMOOTH);

        readyPrompt = new ImageObject(
                new ImageIcon(readyImg), (W - BUBBLE_W) / 2, PADDING, BUBBLE_W, BUBBLE_H);
        objects.add(readyPrompt);

        checkButton = new Button(Color.GREEN, (W - CHECK_W) / 2, BUBBLE_H + 2 * PADDING, CHECK_W, CHECK_H, 0) {
            @Override
            public void onClick() {
                handleCheck();
            }
        };
        objects.add(checkButton);

    }

    private void handleCheck() {
        readyPrompt.visible = false;
        checkButton.visible = false;

        if (!fight.canFight(factsCollected)) {
            showBubble("YouNeedMoreFacts.png", (W - BUBBLE_W) / 2, PADDING, BUBBLE_W, BUBBLE_H);
            return;
        }
        showBubble("ReadyToFight.png", (W - BUBBLE_W) / 2, PADDING, BUBBLE_W, BUBBLE_H);
        showQuestionAndChoices();
    }

    private void showBubble(String filename, int w, int h, int x, int y) {
        ImageIcon raw = new ImageIcon(filename);
        Image img = raw.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        objects.add(new ImageObject(new ImageIcon(img), x, y, w, h));
    }

    private void showQuestionAndChoices() {
        showBubble(
                fight.getCurrentQuestion(), QW, QH, (W - QW) / 2, BUBBLE_H + 3 * PADDING);

        List<String> choices = fight.getCurrentChoices();
        Point[] pts = {
                new Point((W - QW) / 2, BUBBLE_H + QH + 4 * PADDING),
                new Point((W - QW) / 2 + ACW + PADDING, BUBBLE_H + QH + 4 * PADDING),
                new Point((W - QW) / 2, BUBBLE_H + QH + 5 * PADDING + ACH),
                new Point((W - QW) / 2 + ACW + PADDING, BUBBLE_H + QH + 5 * PADDING + ACH)
        };
        for (int i = 0; i < choices.size(); i++) {
            final int index = i;
            ImageIcon rawC = new ImageIcon(choices.get(i));
            Image cImg = rawC.getImage().getScaledInstance(ACW, ACH, Image.SCALE_SMOOTH);
            ImageButton choiceBtn = new ImageButton(new ImageIcon(cImg), pts[i].x, pts[i].y, ACW, ACH, 0) {
                
                public void onClick() {
                    boolean correct = fight.answer(index);
                    JOptionPane.showMessageDialog(null,
                            correct ? "Correct! You defeated the boss!" : "Wrong! Try again.");
                    if (correct) {
                        TimeMachineGame.changeScreen(6);
                    }
                }
            };
            objects.add(choiceBtn);
        }
    }

    @Override
    public void draw(Graphics g, int px, int py) {
        if (!visible)
            return;
        g.drawImage(backgroundImg, 0, 0, null);

        frameCounter++;
        if(frameCounter > 60 && bossSpriteY < SPRITE_TARGET_Y) {
            bossSpriteY +=4;
            if(bossSpriteY > SPRITE_TARGET_Y) {
                bossSpriteY = SPRITE_TARGET_Y;
            }
        }
        g.drawImage(bossSpriteImg, SPRITE_X, bossSpriteY, null);
        for (GameObject obj : objects) {
            obj.draw(g, 0, 0);
        }
    }

}
