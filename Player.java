import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Player{
    private int x;
    private int y;
    private int speed;
    private int health;
    private Image sprite;
    private Set<Image> collectedFacts;

    public Player(int startX, int startY, int speed, Image sprite){
        x = startX;
        y = startY; 
        this.speed = speed;
        health = 100;
        this.sprite = sprite;
        collectedFacts = new HashSet<>();
    }

    public void moveLeft(){
        x-= speed;
    }

    public void moveRight(){
        x += speed;
    }

    public void moveUp(){
        y -= speed;
    }

    public void moveDown(){
        y += speed;
    }

    public void collectFact(Image factImage){
        if(!collectedFacts.contains(factImage)){
            collectedFacts.add(factImage);
            System.out.println("Collected fact: " + factImage);
        }
    }

    public boolean hasFact(Image factImage){
        return collectedFacts.contains(factImage);
    }

    public int getFactCount(){
        return collectedFacts.size();
    }

    public void takeDamage(int damage){
        health -= damage;
        if(health < 0) health = 0;
        System.out.println("Player took " + damage + " damage. Health: " + health);
    }

    public void heal(int amount){
        health += amount;
        if(health > 100) health = 100;
        System.out.println("Player healed. Health: " + health);
    }

    public int getHealth(){
        return health;
    }

    public void render(Graphics g){
        g.drawImage(sprite, x, y, null);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setx(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}