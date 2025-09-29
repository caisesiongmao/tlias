package com.tlias;

import org.junit.jupiter.api.Test;


public class ThreadLocalTest {

    public ThreadLocal<String> threadLocal = new ThreadLocal<>();


    @Test
    public void test() {
        threadLocal.set("main message");

        new Thread(new MyThread()).start();
        System.out.println(threadLocal.get());
        threadLocal.remove();

    }
}

class MyThread implements Runnable {

    ThreadLocalTest threadLocalTest = new ThreadLocalTest();

    @Override
    public void run() {
        threadLocalTest.threadLocal.set("myThread message");
        System.out.println(threadLocalTest.threadLocal.get());
    }
}


