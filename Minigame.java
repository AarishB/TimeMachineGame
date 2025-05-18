public class Minigame {
    private String name;
    private String description;
    private boolean isCompleted;
    private String factReward;

    public Minigame(String name, String description, String factReward) {
        this.name = name;
        this.description = description;
        this.factReward = factReward;
        this.isCompleted = false
    }
}
