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
    public Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.findFourOfAKind()
                .mapToInt(die -> die * SCORE_FACTOR_FOUR_OF_A_KIND)
                .findFirst()
                .orElse(SCORE_ZERO);
    }
}
