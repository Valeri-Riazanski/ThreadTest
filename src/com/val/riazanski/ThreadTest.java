package com.val.riazanski;

import java.util.ArrayList;
import java.util.List;

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
        //book.metachange(2, "W*W*W*W*W*W");
        //System.out.println(book.getList().toString());

        Runnable t1 = () -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(ConsoleColors.GREEN + "1 thread before" + book.getList().toString() + ConsoleColors.RESET);
                    book.metaChange(0, randomString());
                    System.out.println(ConsoleColors.CYAN + "1 thread after" + book.getList().toString() + ConsoleColors.RESET);
                    Thread.sleep((int) (10 * Math.random()));

                }
            } catch (InterruptedException e) {
                {
                }
            }
        };
        Runnable t2 = () -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(ConsoleColors.PURPLE + "2 thread before" + book.getList().toString() + ConsoleColors.RESET);
                    book.metaChange(1, randomString());
                    System.out.println(ConsoleColors.BLUE + "2 thread after" + book.getList().toString() + ConsoleColors.RESET);
                    Thread.sleep((int) (10 * Math.random()));

                }
            } catch (InterruptedException e) {
                {
                }
            }
        };
        Thread thread;
        new Thread(t1).start();
        new Thread(t2).start();
    }


}
