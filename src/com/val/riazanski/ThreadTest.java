package com.val.riazanski;

import java.util.concurrent.Callable;

import static java.lang.Math.random;

public class ThreadTest {
    static String randomString() {
        final int valueAlphabet = 26;
        final int shift = 97;
        final int n = 10;
        char firstChar;
        String str = "";
        for (int i = 0; i < n; i++) {
            firstChar = (char) ((int) (shift + valueAlphabet * random()));
            str = str + firstChar;
        }
        return str;
    }

    public static void main(String[] args) {
        Book book;
        book = new Book(3);
        Runnable t1 = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(ConsoleColors.GREEN + threadName + book.getList().toString() + ConsoleColors.RESET);
                    book.metaChange(0, randomString());
                    System.out.println(ConsoleColors.CYAN + threadName + book.getList().toString() + ConsoleColors.RESET);
                    Thread.sleep((int) (10 * Math.random()));
                }
            } catch (InterruptedException e) {
                {
                }
            }
        };
        Runnable t2 = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(ConsoleColors.PURPLE + threadName + book.getList().toString() + ConsoleColors.RESET);
                    book.metaChange(1, randomString());
                    System.out.println(ConsoleColors.BLUE + threadName + book.getList().toString() + ConsoleColors.RESET);
                    Thread.sleep((int) (10 * Math.random()));
                }
            } catch (InterruptedException e) {
                {
                }
            }
        };
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
