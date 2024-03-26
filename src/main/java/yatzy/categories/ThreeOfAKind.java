package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public class ThreeOfAKind extends Category {
    public ThreeOfAKind(Roll roll) {
        super(roll);
    }

    public static ThreeOfAKind of(Roll roll){
        return new ThreeOfAKind(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> roll.findThreeOfAKind()
                .mapToInt(die -> die * 3)
                .findFirst().orElse(0);
    }
}