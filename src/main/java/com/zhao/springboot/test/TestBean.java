package com.zhao.springboot.test;

import org.springframework.stereotype.Service;

@Service
public class TestBean {

    public void fun() {
        System.out.println("我是文件function");
    }

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (a) {
                    synchronized (b) {
                        System.out.println("你好");
                    }
                }
            }

        }).start();

        new Thread(() -> {
            while (true){
                synchronized (b) {
                    synchronized (a) {
                        System.out.println("你好");
                    }
                }
            }
        }).start();


    }


}
