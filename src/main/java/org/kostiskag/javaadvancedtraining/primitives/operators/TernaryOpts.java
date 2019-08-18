package org.kostiskag.javaadvancedtraining.primitives.operators;

import java.sql.SQLOutput;

public class TernaryOpts {
    public static void main(String[] args) {

        //which will be the output???
        System.out.println( 4!=5?4==4?1:2 :5);

        int x = 5;
        System.out.println(x++!=4?++x:x--);
        System.out.println(x);

        int y = 500;

        y = x>y? 200: y; // you can't miss the else part!
        System.out.println("y " + y);

        boolean v = true;
        System.out.println(v = false != true?!v:v);
    }
}
