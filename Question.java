import javax.swing.*;

public class Question {
    private String text;           
    private String[] options;      
    private int correctIndex;      
    private ImageIcon image;       
    private String fact;           

    public Question(String text, String[] options, int correctIndex, ImageIcon image, String fact) {
        this.text = text;
        this.options = options;
        this.correctIndex = correctIndex;
        this.image = image;
        this.fact = fact;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public ImageIcon getImage() {
        return image;
    }

    public String getFact() {
        return fact;
    }

    public boolean isCorrect(int selectedIndex) {
        return selectedIndex == correctIndex;
    }
}