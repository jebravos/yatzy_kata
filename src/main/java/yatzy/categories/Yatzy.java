package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class Yatzy extends Category {

    public Yatzy(Roll roll) {
        super(roll);
    }

    public static Yatzy of(Roll roll) {
        return new Yatzy(roll);
    }

    @Override
    public Function<Roll, Integer> getScoreFunction() {
        return roll ->  roll.isYatzy() ? SCORE_FIFTY : SCORE_ZERO;
    }
}
