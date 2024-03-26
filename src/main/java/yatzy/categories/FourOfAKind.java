package yatzy.categories;

import yatzy.Roll;

public class FourOfAKind extends Category{
    public FourOfAKind(Roll roll) {
        super(roll);
    }

    public static FourOfAKind of(Roll roll){
        return new FourOfAKind(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.findFourOfAKind()
                .mapToInt(die -> die * 4)
                .findFirst().orElse(0);
    }
}
