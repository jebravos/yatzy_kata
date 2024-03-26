package yatzy.categories;


import yatzy.Roll;

public abstract class Category {
    protected final Roll roll;

    protected Category(Roll roll) {
        this.roll = roll;
    }

    abstract Integer computeScore();
}

