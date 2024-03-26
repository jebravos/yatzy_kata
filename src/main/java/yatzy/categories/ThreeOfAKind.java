package yatzy.categories;

import yatzy.Roll;

public class ThreeOfAKind extends Category{
    public ThreeOfAKind(Roll roll) {
        super(roll);
    }

    public static ThreeOfAKind of(Roll roll){
        return new ThreeOfAKind(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.findThreeOfAKind()
                .mapToInt(die -> die * 3)
                .findFirst().orElse(0);
    }
}