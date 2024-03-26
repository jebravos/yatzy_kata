package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class Pair extends Category{
    protected Pair(Roll roll) {
        super(roll);
    }

    public static Pair of(Roll roll){
        return new Pair(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.pair(this.roll);
    }
}