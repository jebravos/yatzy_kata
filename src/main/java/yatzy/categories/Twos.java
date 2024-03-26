package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;
import java.util.function.Predicate;

import static yatzy.Roll.DICE_TWO;

public class Twos extends Category {
    public Twos(Roll roll) {
        super(roll);
    }

    public static Twos of(Roll roll) {
        return new Twos(roll);
    }

    @Override
    public Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(diceScoringTwo())
                .reduce(Integer::sum)
                .orElse(SCORE_ZERO);
    }

    private Predicate<Integer> diceScoringTwo() {
        return die -> die == DICE_TWO;
    }

}
