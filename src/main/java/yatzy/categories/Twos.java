package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class Twos extends Category {
    protected Twos(Roll roll) {
        super(roll);
    }

    public static Twos of(Roll roll){
        return new Twos(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.twos(this.roll);
    }
}
