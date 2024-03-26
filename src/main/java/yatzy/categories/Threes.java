package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class Threes extends Category {
    public Threes(Roll roll) {
        super(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(die -> die == 3)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static Threes of(Roll roll) {
        return new Threes(roll);
    }

}