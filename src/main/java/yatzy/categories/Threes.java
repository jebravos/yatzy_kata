package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;
import java.util.function.Predicate;

import static yatzy.Roll.DICE_THREE;

public class Threes extends Category {
    public Threes(Roll roll) {
        super(roll);
    }

    public static Threes of(Roll roll) {
        return new Threes(roll);
    }
    @Override
    public Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(diceScoringThree())
                .reduce(Integer::sum)
                .orElse(SCORE_ZERO);
    }

    private Predicate<Integer> diceScoringThree() {
        return die -> die == DICE_THREE;
    }

}