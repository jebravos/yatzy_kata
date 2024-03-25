package yatzy;

import java.util.Map;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Roll(int d1, int d2, int d3, int d4, int d5) {
    public int[] getCounts() {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        return counts;
    }
    public Map<Integer, Long> counts(){
        return Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int sumDiceValues() {
        return sumDiceValuesWhen(die -> true);
    }

    public int sumDiceValuesWhen(IntPredicate condition) {
        return IntStream.of(d1, d2, d3, d4, d5)
                .filter(condition)
                .sum();
    }
}
