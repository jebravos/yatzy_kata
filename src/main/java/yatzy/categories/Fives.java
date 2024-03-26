package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;
import java.util.function.Predicate;

import static yatzy.Roll.DICE_FIVE;

public class Fives extends Category {

    public Fives(Roll roll) {
        super(roll);
    }

    public static Fives of(Roll roll){
        return new Fives(roll);
    }

    @Override
    public Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(diceScoringFive())
                .reduce(Integer::sum)
                .orElse(SCORE_ZERO);
    }

    private Predicate<Integer> diceScoringFive() {
        return die -> die == DICE_FIVE;
    }
}