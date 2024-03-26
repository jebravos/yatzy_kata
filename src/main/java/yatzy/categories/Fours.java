package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class Fours extends Category {
    public Fours(Roll roll) {
        super(roll);
    }

    public static Fours of(Roll roll){
        return new Fours(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(die -> die == 4)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
