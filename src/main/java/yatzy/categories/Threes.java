package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class Threes extends Category {
    protected Threes(Roll roll) {
        super(roll);
    }

    public static Threes of(Roll roll){
        return new Threes(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.threes(this.roll);
    }
}