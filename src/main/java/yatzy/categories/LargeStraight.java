package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class LargeStraight extends Category{
    protected LargeStraight(Roll roll) {
        super(roll);
    }

    public static LargeStraight of(Roll roll){
        return new LargeStraight(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.largeStraight(this.roll);
    }
}
