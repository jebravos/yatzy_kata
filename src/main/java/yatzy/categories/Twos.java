package yatzy.categories;

import yatzy.Roll;

public class Twos extends Category {
    protected Twos(Roll roll) {
        super(roll);
    }

    public static Twos of(Roll roll){
        return new Twos(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.sumDiceValuesWhen(die -> die == 2);
    }
}
