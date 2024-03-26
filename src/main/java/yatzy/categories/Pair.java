package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class Pair extends Category {

    public Pair(Roll roll) {
        super(roll);
    }

    public static Pair of(Roll roll) {
        return new Pair(roll);
    }

    @Override
    public Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.findHighestPair()
                .map(die -> die * SCORE_FACTOR_PAIR)
                .orElse(SCORE_ZERO);
    }
}