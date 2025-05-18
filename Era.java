import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Era{
    private String name;
    private String description;
    private List<Image> facts;
    private List<Minigame> minigames;
    private boolean isCompleted;

    public Era(String name, String description){
        this.name = name;
        this.description = description;
        this.facts = new ArrayList<>();
        this.minigames = new ArrayList<>();
        this.isCompleted = false;
    }

    public void addFact(Image fact){
        facts.add(fact);
    }

    public Image getRandomFact(){
        if(facts.isEmpty()) {
            System.out.println("You collected 0 facts");
            return null;
        }
        int index = (int)(Math.random() * facts.size());
        return facts.get(index);
    }

    public boolean isComplete(){
        return isCompleted;
    }

    public void complete(){
        this.isCompleted = true;
    }

    public List<Minigame> getMinigames(){
        return minigames;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
    public List<Image> getAllFacts() {
        return facts;
    }

    public void clearFacts() {
        facts.clear();
        System.out.println("All facts cleared");
    }
    @Override
    public String toString(){
        return name + ": " + description;
    }
    public void addMinigame(Minigame minigame) {
        minigames.add(minigame);
    }
}