package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class SmallStraight extends Category {

    public SmallStraight(Roll roll) {
        super(roll);
    }

    public static SmallStraight of(Roll roll) {
        return new SmallStraight(roll);
    }

    @Override
    public Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.isSmallStraight() ? SCORE_FIFTEEN : SCORE_ZERO;
    }
}