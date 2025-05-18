import javax.swing.*;
public abstract class Minigame {
    private String name;
    private String description;
    private boolean isCompleted;
    private String factReward;
    protected JFrame frame;

    public Minigame(String name, String description, String factReward) {
        this.name = name;
        this.description = description;
        this.factReward = factReward;
        this.isCompleted = false;
    }
    public abstract void start();
    protected void complete() {
        isCompleted = true;
        JOptionPane.showMessageDialog(frame, "You compeleted" + name  + "!");
        frame.dispose();
    }
    public boolean isCompleted() {
        return isCompleted;
    }   
    public String getName() {
        return name;
    }
}
