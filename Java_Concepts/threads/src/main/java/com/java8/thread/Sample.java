package com.java8.thread;


public class Sample {

    private int count = 1;
    private static final int MAX = 10;
    private boolean[] check = {true, false, false};

    public static void main(String[] args) {
        Sample test = new Sample();
        Thread t1 = new Thread(() -> {
            while(test.count <= test.MAX)
                test.one();
        });

        Thread t2 = new Thread(() -> {
            while(test.count <= MAX)
                test.two();
        });

        Thread t3 = new Thread(() -> {
            while(test.count <= MAX)
                test.three();
        });

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");
        t1.start();
        t2.start();
        t3.start();
    }

    private synchronized void one() {
        while(!check[0]) {
            try {
                wait();
            } catch(InterruptedException ie) {
            }
        }
        System.out.println(Thread.currentThread().getName() + count++);
        check[0] = false;
        check[1] = true;
        notifyAll();

    }

    private synchronized void two() {
        while(!check[1]) {
            try {
                wait();
            } catch(InterruptedException ie) {
            }
        }
        System.out.println(Thread.currentThread().getName() + count++);
        check[1] = false;
        check[2] = true;
        notifyAll();
    }

    private synchronized void three() {
        while(!check[2]) {
            try {
                wait();
            } catch(InterruptedException ie) {
            }
        }
        System.out.println(Thread.currentThread().getName() + count++);
        check[2] = false;
        check[0] = true;
        notifyAll();
    }

}
