package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class FourOfAKind extends Category {
    public FourOfAKind(Roll roll) {
        super(roll);
    }

    public static FourOfAKind of(Roll roll) {
        return new FourOfAKind(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.findFourOfAKind()
                .mapToInt(die -> die * 4)
                .findFirst().orElse(0);
    }
}
