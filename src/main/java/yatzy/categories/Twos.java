package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class Twos extends Category {
    public Twos(Roll roll) {
        super(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.find(die -> die == 2)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static Twos of(Roll roll) {
        return new Twos(roll);
    }

}
