package yatzy.categories;

import yatzy.Roll;

import java.util.Optional;
import java.util.function.Function;

public class FullHouse extends Category{

    public FullHouse(Roll roll) {
        super(roll);
    }

    public static FullHouse of(Roll roll){
        return new FullHouse(roll);
    }

    @Override
    public Function<Roll, Integer> getScoreFunction() {
        return roll -> {
            Optional<Integer> pair = roll.findHighestPair()
                    .stream()
                    .findFirst();

            Optional<Integer> threeOfAKind = roll.findThreeOfAKind()
                    .findAny();


            if (pair.isPresent() && threeOfAKind.isPresent()) {
                return pair.get() * SCORE_FACTOR_PAIR + threeOfAKind.get() * SCORE_FACTOR_THREE_OF_A_KIND;

            } else {
                return SCORE_ZERO;
            }
        };
    }
}
