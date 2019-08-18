package org.kostiskag.javaadvancedtraining.utils;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringTokenizeJoinTesting {

    public static void main(String[] args) {
        String str = "HEllo! I am obviously a string!";
        StringTokenizer tok = new StringTokenizer(str, " ");
        System.out.println(tok.countTokens());

        //tok. //no stream in tokenizer

        StringJoiner join = new StringJoiner(" ");
        join.add(tok.nextToken());
        join.add(tok.nextToken());
        join.add(tok.nextToken());
        join.add(tok.nextToken());
        join.add(tok.nextToken());
        join.add(tok.nextToken());

        System.out.println(join);
    }
}
