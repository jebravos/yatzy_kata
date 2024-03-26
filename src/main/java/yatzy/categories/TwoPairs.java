package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class TwoPairs extends Category{
    protected TwoPairs(Roll roll) {
        super(roll);
    }

    public static TwoPairs of(Roll roll){
        return new TwoPairs(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.twoPairs(this.roll);
    }
}
