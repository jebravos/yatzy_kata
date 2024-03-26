package yatzy.categories;

import yatzy.Roll;

public class Fives extends Category{
    public Fives(Roll roll) {
        super(roll);
    }

    public static Fives of(Roll roll){
        return new Fives(roll);
    }
    @Override
    public Integer computeScore() {
        return roll.find(die -> die == 5)
                .reduce(Integer::sum)
                .orElse(0);
    }
}