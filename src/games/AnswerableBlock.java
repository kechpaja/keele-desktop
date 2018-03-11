package games;

import java.util.Set;

public class AnswerableBlock extends Block {
    
    private Set<String> possibleAnswers_;

    protected AnswerableBlock(int heightInUnits, Set<String> possibleAnswers) {
        super(heightInUnits);
        this.possibleAnswers_ = possibleAnswers;
    }
    
    protected boolean isPossibleAnswer(String answer) {
        return this.possibleAnswers_.contains(answer);
    }

}
