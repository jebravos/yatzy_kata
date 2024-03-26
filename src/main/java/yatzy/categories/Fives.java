package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class Fives extends Category{
    protected Fives(Roll roll) {
        super(roll);
    }

    public static Fives of(Roll roll){
        return new Fives(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.fives(this.roll);
    }
}