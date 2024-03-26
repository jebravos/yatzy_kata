package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class LargeStraight extends Category {
    public LargeStraight(Roll roll) {
        super(roll);
    }

    public static LargeStraight of(Roll roll) {
        return new LargeStraight(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.isLargeStraight() ? 20 : 0;
    }
}
