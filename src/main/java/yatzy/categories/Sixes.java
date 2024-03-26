package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class Sixes extends Category {
    protected Sixes(Roll roll) {
        super(roll);
    }

    public static Sixes of(Roll roll){
        return new Sixes(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.sixes(this.roll);
    }
}