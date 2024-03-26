package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class ThreeOfAKind extends Category{
    protected ThreeOfAKind(Roll roll) {
        super(roll);
    }

    public static ThreeOfAKind of(Roll roll){
        return new ThreeOfAKind(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.threeOfAKind(this.roll);
    }
}