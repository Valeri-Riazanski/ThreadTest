package com.val.riazanski;

import static java.lang.Math.random;

public class ThreadTest {
    static String randomString() {
        final int valueAlphabet = 26;
        final int shift = 97;
        final int n = 5;
        char firstChar;
        String str = "";
        for (int i = 0; i < n; i++) {
            firstChar = (char) ((int) (shift + valueAlphabet * random()));
            str = str + firstChar;
        }
        return str;
    }

    public static void main(String[] args) throws InterruptedException {
        Book book;
        book = new Book(3);
        Runnable t1 = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(threadName + " = " + Thread.currentThread().getState());
                    System.out.println(ConsoleColors.GREEN + threadName + book.getList().toString() + ConsoleColors.RESET);
                    book.metaChange(0, randomString());
                    System.out.println(ConsoleColors.CYAN + threadName + book.getList().toString() + ConsoleColors.RESET);
                    Thread.currentThread().join(5);
                    System.out.println(threadName + " = " + Thread.currentThread().getState());
                }
            } catch (InterruptedException e) {
                {
                }
            }
        };
        Runnable t2 = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(threadName + " = " + Thread.currentThread().getState());
                    System.out.println(ConsoleColors.PURPLE + threadName + book.getList().toString() + ConsoleColors.RESET);
                    book.metaChange(1, randomString());
                    System.out.println(threadName + " = " + Thread.currentThread().getState());
                    System.out.println(ConsoleColors.BLUE + threadName + book.getList().toString() + ConsoleColors.RESET);
                    Thread.currentThread().join(2);
                    //Thread.sleep((int) (10 * Math.random()));
                    //System.out.println(threadName + " = " + Thread.currentThread().getState());
                }
            } catch (InterruptedException e) {
                {
                }
            }
        };
        Thread threadGreen = new Thread(t1);
        threadGreen.setName("thread Green");
        Thread threadPurple = new Thread(t2);
        threadPurple.setName("thread Purple");
        System.out.println("thread Green =  " + threadGreen.getState());
        System.out.println("thread Purple =  " + threadPurple.getState());
        threadGreen.start();
        // threadGreen.join( 3);
        threadPurple.start();
    }
}
