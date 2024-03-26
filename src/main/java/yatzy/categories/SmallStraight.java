package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class SmallStraight extends Category{
    protected SmallStraight(Roll roll) {
        super(roll);
    }

    public static SmallStraight of(Roll roll){
        return new SmallStraight(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.smallStraight(this.roll);
    }
}