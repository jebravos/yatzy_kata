package yatzy.categories;

import yatzy.Roll;

public class SmallStraight extends Category {
    public SmallStraight(Roll roll) {
        super(roll);
    }

    public static SmallStraight of(Roll roll) {
        return new SmallStraight(roll);
    }

    @Override
    public Integer computeScore() {
        return roll.isSmallStraight() ? 15 : 0;
    }
}