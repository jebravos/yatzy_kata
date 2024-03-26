package yatzy.categories;

import yatzy.Roll;

public class Sixes extends Category {
    public Sixes(Roll roll) {
        super(roll);
    }

    public static Sixes of(Roll roll){
        return new Sixes(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.find(die -> die == 6)
                .reduce(Integer::sum)
                .orElse(0);
    }
}