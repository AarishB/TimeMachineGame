import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

public class FactTracker {
    private Set<Image> collectedFacts;
    private int totalFactsNeededForBoss;

    public FactTracker(int totalFactsNeededForBoss){
        collectedFacts = new HashSet<>();
        this.totalFactsNeededForBoss = totalFactsNeededForBoss;
    }

    public void addFact(Image factImage){
        if(!collectedFacts.contains(factImage)){
            collectedFacts.add(factImage);
            System.out.println("Collected a new fact!");
        }
        else System.out.println("Fact already collected");
    }

    public boolean hasFact(Image factImage){
        return collectedFacts.contains(factImage);
    }

    public int getFactCount(){
        return collectedFacts.size();
    }

    public boolean canFightBoss(){
        return collectedFacts.size() >= totalFactsNeededForBoss;
    }

    public void reset(){
        collectedFacts.clear();
        System.out.println("Fact tracker reset.");
    }

    public Set<Image> getAllFacts(){
        return collectedFacts;
    }

    @Override
    public String toString(){
        return "Collected Facts (" + collectedFacts.size() + "): " + collectedFacts;
    }
}