package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class Chance extends Category {

    private Chance(Roll roll) {
        super(roll);
    }

    @Override
    public Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.dice()
                .reduce(Integer::sum)
                .orElse(SCORE_ZERO);
    }

    public static Chance of(Roll roll) {
        return new Chance(roll);
    }

}
