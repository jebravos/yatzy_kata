package yatzy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Roll(int d1, int d2, int d3, int d4, int d5) {

    public static final int DICE_ONE = 1;
    public static final int DICE_TWO = 2;
    public static final int DICE_THREE = 3;
    public static final int DICE_FOUR = 4;
    public static final int DICE_FIVE = 5;
    public static final int DICE_SIX = 6;
    public static final int PAIR = 2;
    public static final int THREE_OF_A_KIND = 3;
    public static final int FOUR_OF_A_KIND = 4;
    public static final int YATZY = 5;
    public static final List<Integer> SMALL_STRAIGHT = List.of(DICE_ONE, DICE_TWO, DICE_THREE, DICE_FOUR, DICE_FIVE);
    public static final List<Integer> LARGE_STRAIGHT = List.of(DICE_TWO, DICE_THREE, DICE_FOUR, DICE_FIVE, DICE_SIX);

    public Stream<Integer> find(Predicate<Integer> condition) {
        return dice()
                .filter(condition);
    }

    public Stream<Integer> dice() {
        return Stream.of(d1, d2, d3, d4, d5);
    }

    public Optional<Integer> findHighestPair() {
        return this.findPairs()
                .reduce(Integer::max);
    }

    public Stream<Integer> findPairs() {
        return findOccurrences(PAIR);
    }

    public Stream<Integer> findThreeOfAKind() {
        return findOccurrences(THREE_OF_A_KIND);
    }

    public Stream<Integer> findFourOfAKind() {
        return findOccurrences(FOUR_OF_A_KIND);
    }

    public boolean isYatzy() {
        return findOccurrences(YATZY)
                .findAny()
                .isPresent();
    }

    public boolean isSmallStraight() {
        return new HashSet<>(this.counts()
                .keySet())
                .containsAll(SMALL_STRAIGHT);
    }

    public boolean isLargeStraight() {
        return new HashSet<>(this.counts()
                .keySet())
                .containsAll(LARGE_STRAIGHT);
    }

    private Stream<Integer> findOccurrences(int x) {
        return this.counts()
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= x)
                .map(Map.Entry::getKey);
    }

    private Map<Integer, Long> counts() {
        return dice()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
