package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;
import java.util.function.Predicate;

import static yatzy.Roll.DICE_SIX;

public class Sixes extends Category {
    public Sixes(Roll roll) {
        super(roll);
    }

    public static Sixes of(Roll roll){
        return new Sixes(roll);
    }

    @Override
    public Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(diceScoringSix())
                .reduce(Integer::sum)
                .orElse(SCORE_ZERO);
    }

    private Predicate<Integer> diceScoringSix() {
        return die -> die == DICE_SIX;
    }
}