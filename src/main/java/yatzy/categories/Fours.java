package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class Fours extends Category{
    protected Fours(Roll roll) {
        super(roll);
    }

    public static Fours of(Roll roll){
        return new Fours(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.fours(this.roll);
    }
}
