package yatzy;

public class Yatzy {

    public static int chance(Roll roll) {
        return roll.sumDiceValues();
    }

    public static int yatzy(Roll roll) {
        return roll.counts()
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 5)
                .findAny()
                .map(entry -> 50)
                .orElse(0);
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
        int[] counts = roll.getCounts();

        for (int at = 0; at < 6; at++) {

            if (counts[6 - at - 1] >= 2) {
                return (6 - at) * 2;
            }
        }

        return 0;
    }


    public static int twoPairs(Roll roll) {
        int[] counts = roll.getCounts();

        int numberOfPairs = 0;
        int score = 0;

        for (int at = 0; at < 6; at++) {
            if (counts[6 - at - 1] >= 2) {
                numberOfPairs++;
                score += (6 - at);
            }
        }

        if (numberOfPairs == 2) {
            return score * 2;
        } else {
            return 0;
        }
    }

    public static int threeOfAKind(Roll roll) {
        return roll.counts()
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 3)
                .mapToInt(entry -> entry.getKey() * 3)
                .max()
                .orElse(0);
    }

    public static int fourOfAKind(Roll roll) {
        return roll.counts()
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 4)
                .mapToInt(entry -> entry.getKey() * 4)
                .max()
                .orElse(0);
    }

    public static int smallStraight(Roll roll) {
        int[] counts = roll.getCounts();

        if (counts[0] == 1 && counts[1] == 1 && counts[2] == 1 && counts[3] == 1 && counts[4] == 1) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(Roll roll) {
        int[] counts = roll.getCounts();

        if (counts[1] == 1 && counts[2] == 1 && counts[3] == 1 && counts[4] == 1 && counts[5] == 1) {
            return 20;
        }

        return 0;
    }

    public static int fullHouse(Roll roll) {
        int[] counts = roll.getCounts();


        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        for (i = 0; i != 6; i += 1)
            if (counts[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (counts[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3) return _2_at * 2 + _3_at * 3;
        else return 0;
    }

}