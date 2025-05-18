import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boss{
    private String name;
    private int health;
    private int maxHealth;
    private Image bossSprite;
    private List<Image> questionImages;
    private boolean isDefeated;

    public Boss(String name, int maxHealth, Image bossSprite){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.bossSprite = bossSprite;
        this.questionImages = new ArrayList<>();
        this.isDefeated = false;
    }

    public void addQuestionImage(Image questionImage){
        questionImages.add(questionImage);
    }

    public Image askQuestion(){
        if(questionImages.isEmpty()){
            System.out.println("Boss has no questions set.");
            return null;
        }

        Random random = new Random();
        Image questionImage = questionImages.get(random.nextInt(questionImages.size()));
        return questionImage;
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

    public Image getBossSprite(){
        return bossSprite;
    }

    public List<Image> getAllQuestionImages(){
        return questionImages;
    }

    @Override
    public String toString(){
        return name + " (Health: " + health + "/" + maxHealth + ")";
    }
}