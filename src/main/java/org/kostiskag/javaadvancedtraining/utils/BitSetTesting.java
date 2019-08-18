package org.kostiskag.javaadvancedtraining.utils;

import java.util.Arrays;
import java.util.BitSet;

public class BitSetTesting {
    public static void main(String[] args) {
        BitSet bi = new BitSet(15);
        bi.set(0,15, true);
        bi.set(15,20, false);
        bi.set(20,25, true);
        bi.set(18,true);
        bi.set(25); //set with no value makes true
        System.out.println(bi);
        System.out.println(bi.size());
        System.out.println(Arrays.toString(bi.toByteArray()));


    }
}
