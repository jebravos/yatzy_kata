package yatzy.categories;

import yatzy.Roll;

public class Ones extends Category{
    public Ones(Roll roll) {
        super(roll);
    }

    public static Ones of(Roll roll){
        return new Ones(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.find(die -> die == 1)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
