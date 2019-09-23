package com.zhao.springboot.test;

public class ThreadB implements Runnable{

    Object a ;
    Object b ;
    ThreadB(Object a , Object b) {
        this.a = a ;
        this.b = b ;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (b) {
                synchronized (a) {
                    System.out.println("你好");
                }
            }
        }
    }

}
