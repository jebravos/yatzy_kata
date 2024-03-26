package yatzy.categories;

import yatzy.Roll;

public class Twos extends Category {
    public Twos(Roll roll) {
        super(roll);
    }

    public static Twos of(Roll roll){
        return new Twos(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.find(die -> die == 2)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
