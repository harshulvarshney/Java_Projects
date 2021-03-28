package com.java.core;

public abstract class AnInterestingCase3 {

    public static void main(String[] args) {
        //AnAbstractClass a = new AnAbstractClass();
    }

}

abstract class AnAbstractClass {

    private final int height;
    private final int weight;

    public AnAbstractClass() {
        this.height = height();
        this.weight = weight();
    }

    abstract protected int height();
    abstract public int weight();
}

class Test extends AnAbstractClass {
    private final int test;

    public Test(int t) {
        this.test = t;
    }

    @Override
    protected int height() {
        return 10;
    }

    @Override
    public int weight() {
        return 12;
    }
}
