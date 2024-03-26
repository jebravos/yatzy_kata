package yatzy.categories;

import yatzy.Roll;

public class Ones extends Category{
    protected Ones(Roll roll) {
        super(roll);
    }

    public static Ones of(Roll roll){
        return new Ones(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.sumDiceValuesWhen(die -> die == 1);
    }
}
