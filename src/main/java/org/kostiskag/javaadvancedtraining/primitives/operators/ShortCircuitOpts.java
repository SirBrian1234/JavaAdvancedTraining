package org.kostiskag.javaadvancedtraining.primitives.operators;

import java.util.List;

/**
 * short-circuit in java are
 * && and ||
 * page 83
 */
public class ShortCircuitOpts {
    public static void main(String[] args) {

        List li = null;
        if (li != null && li.size()>5) {
            //this will not create a runtime exception!
        }

//        if (li != null & li.size()>5) {
//            //this will!!!
//        }

        //case (li);

        int x = 5;
        if ( x ==5 || li.size() >5 ) {
            //this will not create a runtime
        }

//        if ( x ==5 | li.size() >5 ) {
//            //this will!
//        }

        int k = 0;
        if ( k != 0 && 5/k == 1) {
            //no runtime!
        }

        if ( k != 0 & 5/k == 1) {
            //runtime java.lang.ArithmeticException: / by zero
        }

    }
}
