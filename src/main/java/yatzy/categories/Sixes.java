package yatzy.categories;

import yatzy.Roll;

public class Sixes extends Category {
    protected Sixes(Roll roll) {
        super(roll);
    }

    public static Sixes of(Roll roll){
        return new Sixes(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.sumDiceValuesWhen(die -> die == 6);
    }
}