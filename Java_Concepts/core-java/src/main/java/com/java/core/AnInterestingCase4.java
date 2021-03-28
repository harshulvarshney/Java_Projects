package com.java.core;

import java.util.Arrays;
import java.util.List;

public class AnInterestingCase4 {

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("a test");
        List<Object> l2 = Arrays.asList("a test");

        String s1 = new TestType<String>().var;
        //String s2 = new TestType<Object>().var;
        Object s3 = new TestType<String>().var;
        Object s4 = new TestType<Object>().var;
    }
}

class TestType<T> {
    public T var;
}
