package yatzy.categories;

import yatzy.Roll;

import java.util.List;
import java.util.function.Function;

public class TwoPairs extends Category {
    public TwoPairs(Roll roll) {
        super(roll);
    }

    public static TwoPairs of(Roll roll){
        return new TwoPairs(roll);
    }

    @Override
    Function<Roll, Integer> getScoreFunction() {
        return roll -> {
            List<Integer> pairs = roll.findPairs()
                    .toList();

            if (pairs.size() == 2) {
                return pairs.stream()
                        .mapToInt(die -> die * 2)
                        .sum();
            } else {
                return 0;
            }
        };
    }
}
