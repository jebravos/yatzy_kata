package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class Sixes extends Category {
    public Sixes(Roll roll) {
        super(roll);
    }

    public static Sixes of(Roll roll){
        return new Sixes(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(die -> die == 6)
                .reduce(Integer::sum)
                .orElse(0);
    }
}