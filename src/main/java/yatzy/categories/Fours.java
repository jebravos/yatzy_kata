package yatzy.categories;

import yatzy.Roll;

public class Fours extends Category{
    protected Fours(Roll roll) {
        super(roll);
    }

    public static Fours of(Roll roll){
        return new Fours(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.sumDiceValuesWhen(die -> die == 4);
    }
}
