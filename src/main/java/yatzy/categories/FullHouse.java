package yatzy.categories;

import yatzy.Roll;
import yatzy.ScoringRules;

public class FullHouse extends Category{
    protected FullHouse(Roll roll) {
        super(roll);
    }

    public static FullHouse of(Roll roll){
        return new FullHouse(roll);
    }
    @Override
    public Integer computeScore() {
        return ScoringRules.fullHouse(this.roll);
    }
}
