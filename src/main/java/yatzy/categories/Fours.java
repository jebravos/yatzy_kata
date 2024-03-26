package yatzy.categories;

import yatzy.Roll;

public class Fours extends Category{
    public Fours(Roll roll) {
        super(roll);
    }

    public static Fours of(Roll roll){
        return new Fours(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.find(die -> die == 4)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
