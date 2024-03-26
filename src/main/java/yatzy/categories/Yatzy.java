package yatzy.categories;

import yatzy.Roll;

public class Yatzy extends Category {
    public Yatzy(Roll roll) {
        super(roll);
    }

    public static Yatzy of(Roll roll) {
        return new Yatzy(roll);
    }

    @Override
    public Integer computeScore() {
        return roll.isYatzy() ? 50 : 0;
    }
}
