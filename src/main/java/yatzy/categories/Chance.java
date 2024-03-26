package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class Chance extends Category {

    private Chance(Roll roll) {
        super(roll);
    }

    public static Chance of(Roll roll) {
        return new Chance(roll);
    }

    @Override
    public Integer computeScore() {
        return ScoringRules.chance(this.roll);
    }
}
