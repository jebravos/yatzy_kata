package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;
import java.util.function.Predicate;

import static yatzy.Roll.DICE_FOUR;

public class Fours extends Category {

    public Fours(Roll roll) {
        super(roll);
    }

    public static Fours of(Roll roll){
        return new Fours(roll);
    }

    @Override
    public Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(diceScoringFour())
                .reduce(Integer::sum)
                .orElse(SCORE_ZERO);
    }

    private Predicate<Integer> diceScoringFour() {
        return die -> die == DICE_FOUR;
    }
}
