package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class FourOfAKind extends Category{
    protected FourOfAKind(Roll roll) {
        super(roll);
    }

    public static FourOfAKind of(Roll roll){
        return new FourOfAKind(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.fourOfAKind(this.roll);
    }
}
