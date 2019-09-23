package com.zhao.springboot.test;

public class ThreadA implements Runnable {

    Object a ;
    Object b ;
    ThreadA(Object a , Object b) {
        this.a = a ;
        this.b = b ;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (a) {
                synchronized (b) {
                    System.out.println("你好");
                }
            }
        }
    }
}
