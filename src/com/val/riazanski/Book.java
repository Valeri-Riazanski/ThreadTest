package com.val.riazanski;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class Book {
    //fields
    private List<String> list = new ArrayList<String>();
    private final int listCounter = 2;
    //constructors
    public Book(int listCounter) {
        this.init(listCounter);
    }
    //methods
    private void init(int listCounter) {
        final int valueAlphabet = 26;
        final int shift = 97;
        final int n = listCounter;
        char firstChar;
        //System.out.println("создали массив из строк");
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int k = 0; k < 10; k++) {
                firstChar = (char) ((int) (shift + valueAlphabet * random()));
                str = str + firstChar;
            }
            list.add(str);
        }
        //System.out.println(list.toString());
    }

    public void metaChange(int fromString, String rePlace) {
        list.set(fromString, rePlace);
        //System.out.println(list.toString());
    }
    public List<String> getList() {
        return this.list;
    }
}
