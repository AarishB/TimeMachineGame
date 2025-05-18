import java.util.List;
public class BossFight{
    private int bossHealth = 100;
    private final int minFactsRequired;
    private final List<String> questionImages;
    private final List<List<String>> answerChoiceImages;
    private int currentQuestionIndex = 0;
    private boolean defeated = false;

    public BossFight(int minFactsRequired, List<String> questionImages, List<List<String>> answerChoiceImages) {
        this.minFactsRequired = minFactsRequired;
        this.questionImages = questionImages;
        this.answerChoiceImages = answerChoiceImages;
    }

    public boolean canFight(int factsCollected){
        return factsCollected >= minFactsRequired;
    }   

    public String getCurrentQuestion(){
        return questionImages.get(currentQuestionIndex);
    }

    public List<String> getCurrentChoices(){
        return answerChoiceImages.get(currentQuestionIndex);
    }   

    public boolean answer(int choiceIndex){
        boolean correct = (choiceIndex == 0);
        if(correct){
            bossHealth = 0;
        }
        return correct;
    }

    public boolean isDefeated(){
        return bossHealth <= 0;
    }
}