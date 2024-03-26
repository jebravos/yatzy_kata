package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;
import java.util.function.Predicate;

import static yatzy.Roll.DICE_ONE;

public class Ones extends Category {
    public Ones(Roll roll) {
        super(roll);
    }

    public static Ones of(Roll roll){
        return new Ones(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(diceScoringOne())
                .reduce(Integer::sum)
                .orElse(SCORE_ZERO);
    }
    private Predicate<Integer> diceScoringOne() {
        return die -> die == DICE_ONE;
    }
}
