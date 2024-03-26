package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class Ones extends Category {
    public Ones(Roll roll) {
        super(roll);
    }

    public static Ones of(Roll roll){
        return new Ones(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(die -> die == 1)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
