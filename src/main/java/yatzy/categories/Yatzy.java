package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class Yatzy extends Category {
    private Yatzy(Roll roll) {
        super(roll);
    }

    public static Yatzy of(Roll roll) {
        return new Yatzy(roll);
    }

    @Override
    public Integer computeScore() {
        return ScoringRules.yatzy(this.roll);
    }
}
