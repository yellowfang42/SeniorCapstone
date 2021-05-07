package charquestiongenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Lindsie
 */
public class charQuestData {

    public List<String> callUp(){
        List<String> quests = new ArrayList<>();
        quests.add("What would happen if the characters best friend died?");
        quests.add("Does the character solve problems by force, logical action, or some other method?");
        quests.add("How does the character react to surprise revelations?");
        quests.add("What dream has the character had as a child?");
        quests.add("What is the characters relationship with family?");
        quests.add("How does the character feel about authority?");
        quests.add("What is the quickest way to the character's heart?");
        quests.add("Is the character religious?");
        quests.add("What stops the character from leaving the plot?");
        quests.add("Can the character face their fears or do they run away?");
        quests.add("Is the character afraid of the antagonist, or annoyed/sometihng else?");
        
        charQuestData obj = new charQuestData();
        int numberOfElements = 3;
        return obj.randomOne(quests, numberOfElements);
    }
    
    public List<String> randomOne(List<String> quests, int totalItems) {
        Random rand = new Random();
        List<String> newList = new ArrayList<>();
        for (int i=0; i<totalItems; i++){
            int randomIndex = rand.nextInt(quests.size());
            newList.add(quests.get(randomIndex));
            quests.remove(randomIndex);
        }
        return newList;
    }
   
}