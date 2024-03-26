package yatzy.categories;

import yatzy.Roll;

import java.util.Optional;

public class FullHouse extends Category{
    public FullHouse(Roll roll) {
        super(roll);
    }

    public static FullHouse of(Roll roll){
        return new FullHouse(roll);
    }
    @Override
    public Integer computeScore() {
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
