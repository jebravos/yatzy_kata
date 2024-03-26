package yatzy.categories;

import yatzy.Roll;

public class Pair extends Category{
    public Pair(Roll roll) {
        super(roll);
    }

    public static Pair of(Roll roll){
        return new Pair(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.findHighestPair()
                .map(die -> die * 2)
                .orElse(0);
    }
}