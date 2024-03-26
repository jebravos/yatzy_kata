package yatzy.categories;

import yatzy.Roll;

import java.util.function.Function;

public abstract class Category {

    public static final int SCORE_ZERO = 0;
    public static final int SCORE_FIFTEEN = 15;
    public static final int SCORE_TWENTY = 20;
    public static final int SCORE_FIFTY = 50;
    public static final int SCORE_FACTOR_PAIR = 2;
    public static final int SCORE_FACTOR_THREE_OF_A_KIND = 3;
    public static final int SCORE_FACTOR_FOUR_OF_A_KIND = 4;

    protected final Roll roll;

    protected Category(Roll roll) {
        this.roll = roll;
    }

    abstract Function<Roll, Integer> getScoreFunction();

    public Integer computeScore() {
        return getScoreFunction().apply(this.roll);
    }


}

