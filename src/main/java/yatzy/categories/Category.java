package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public abstract class Category {

    protected final Roll roll;

    protected Category(Roll roll) {
        this.roll = roll;
    }

    abstract Function<Roll, Integer> getScoreFunction();

    public Integer computeScore() {
        return getScoreFunction().apply(this.roll);
    }


}

