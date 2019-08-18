package org.kostiskag.javaadvancedtraining.overloading;

import java.util.HashSet;
import java.util.Set;

/**
 * In cases of an ambiguous draw, java will not torture the programmer
 * by using the first method from top or the method where the first argument is of type
 * and thus it does not force the programmer to learn tedious c-style rules
 * it will just throw a compiler error!
 *
 * In java there is no significance if a method may appear before or after another
 * what is important is its scope!
 */
public class OverloadingObjectSubtypesAmbiguous {

    //same type for n, supertype for s
    void getMe(Integer n, Set s){
        System.out.println("Greetings "+"getNum(Integer n, Set s)");
    }

    //supertype for n, same type for s
    void getMe(Number n, HashSet s) {
        System.out.println("Greetings "+"giveSet(Number n, HashSet s)");
    }

    public static void main(String[] args) {
        OverloadingObjectSubtypesAmbiguous o = new OverloadingObjectSubtypesAmbiguous();
        Integer i = 5;
        HashSet s = new HashSet();

        //which one of the two methods will be called this time?
        //o.getMe(i,s);
        //NONE!!!! compile time error
        //java: reference to getMe is ambiguous
        //both method getMe ... match

        //can we force it???
        o.getMe(i,(Set) s);
        //or
        o.getMe((Number) i,s);
        //both apply!
        //we have decribed the minimum required typecast
    }


}
