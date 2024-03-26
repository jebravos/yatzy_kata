package yatzy.categories;

import yatzy.Roll;

public class Threes extends Category {
    protected Threes(Roll roll) {
        super(roll);
    }

    public static Threes of(Roll roll){
        return new Threes(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.sumDiceValuesWhen(die -> die == 3);
    }
}