package yatzy.categories;

import yatzy.Roll;

public class Chance extends Category {

    private Chance(Roll roll) {
        super(roll);
    }

    public static Chance of(Roll roll) {
        return new Chance(roll);
    }

    @Override
    public Integer computeScore() {
        return roll.sumDiceValues();
    }
}
