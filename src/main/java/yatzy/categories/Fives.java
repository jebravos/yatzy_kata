package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class Fives extends Category {
    public Fives(Roll roll) {
        super(roll);
    }

    public static Fives of(Roll roll){
        return new Fives(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(die -> die == 5)
                .reduce(Integer::sum)
                .orElse(0);
    }
}