import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Boss{
    private String name;
    private int health;
    private int maxHealth;
    private Map<String, String> factQuestions;
    private boolean isDefeated;

    public Boss(String name, int maxHealth){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.factQuestions = new HashMap<>();
        this.isDefeated = false;
    }

    public void addQuestion(String question, String correctAnswer){
        factQuestions.put(question, correctAnswer);
    }

    public boolean askQuestion(){
        if(factQuestions.isEmpty()){
            System.out.println("Boss has no questions set.");
            return false;
        }

        List<String> questions = factQuestions.keySet().stream().toList();
        Random random = new Random();
        String question = questions.get(random.nextInt(questions.size()));
        String correctAnswer = factQuestions.get(question);

        System.out.println("BOSS QUESTION: " + question);
        System.out.println("Enter your answer: ");

        String playerAnswer = "dummy";

        if(playerAnswer.equalsIgnoreCase(correctAnswer)){
            System.out.println("Correct! You damaged the boss.");
            takeDamage(20);
            return true;
        }
        else{
            System.out.println("Wrong! The boss counterattacks.");
            return false;
        }
    }

    public void takeDamage(int damage){
        this.health -= damage;
        if(this.health <= 0){
            this.health = 0;
            this.isDefeated = true;
            System.out.println(name + " has been defeated!");
        }
        else{
            System.out.println(name + " has " + health + " HP left.");
        }
    }

    public boolean isDefeated(){
        return isDefeated;
    }

    public void reset(){
        this.health = maxHealth;
        this.isDefeated = false;
        System.out.println(name + " has been reset to full health.");
    }

    public int getHealth(){
        return health;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + " (Health: " + health + "/" + maxHealth + ")";
    }
}