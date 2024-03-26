package yatzy;

import java.util.List;
import java.util.Optional;

public class ScoringRules {

    public static int chance(Roll roll) {
        return roll.sumDiceValues();
    }

    public static int yatzy(Roll roll) {
        return roll.isYatzy() ? 50 : 0;
    }

    public static int ones(Roll roll) {
        return roll.sumDiceValuesWhen(die -> die == 1);
    }

    public static int twos(Roll roll) {
        return roll.sumDiceValuesWhen(die -> die == 2);
    }

    public static int threes(Roll roll) {
        return roll.sumDiceValuesWhen(die -> die == 3);
    }

    public static int fours(Roll roll) {
        return roll.sumDiceValuesWhen(die -> die == 4);
    }

    public static int fives(Roll roll) {
        return roll.sumDiceValuesWhen(die -> die == 5);
    }

    public static int sixes(Roll roll) {
        return roll.sumDiceValuesWhen(die -> die == 6);
    }

    public static int pair(Roll roll) {
        return roll.findHighestPair()
                .map(die -> die * 2)
                .orElse(0);
    }

    public static int twoPairs(Roll roll) {
        List<Integer> pairs = roll.findPairs()
                .toList();

        if (pairs.size() == 2) {
            return pairs.stream()
                    .mapToInt(die -> die * 2)
                    .sum();
        } else {
            return 0;
        }

    }

    public static int threeOfAKind(Roll roll) {
        return roll.findThreeOfAKind()
                .mapToInt(die -> die * 3)
                .findFirst().orElse(0);
    }

    public static int fourOfAKind(Roll roll) {
        return roll.findFourOfAKind()
                .mapToInt(die -> die * 4)
                .findFirst().orElse(0);
    }

    public static int smallStraight(Roll roll) {
        return roll.isSmallStraight() ? 15 : 0;
    }


    public static int largeStraight(Roll roll) {
        return roll.isLargeStraight() ? 20 : 0;
    }


    public static int fullHouse(Roll roll) {
        Optional<Integer> pair = roll.findHighestPair()
                .stream()
                .findFirst();

        Optional<Integer> threeOfAKind = roll.findThreeOfAKind()
                .findAny();


        if (pair.isPresent() && threeOfAKind.isPresent()) {
            return pair.get() * 2 + threeOfAKind.get() * 3;

        } else {
            return 0;
        }

    }

}