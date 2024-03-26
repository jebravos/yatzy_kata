package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class Yatzy extends Category {
    public Yatzy(Roll roll) {
        super(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll ->  roll.isYatzy() ? 50 : 0;
    }

    public static Yatzy of(Roll roll) {
        return new Yatzy(roll);
    }

}
