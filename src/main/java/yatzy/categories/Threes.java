package yatzy.categories;

import yatzy.Roll;

public class Threes extends Category {
    public Threes(Roll roll) {
        super(roll);
    }

    public static Threes of(Roll roll){
        return new Threes(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.find(die -> die == 3)
                .reduce(Integer::sum)
                .orElse(0);
    }
}