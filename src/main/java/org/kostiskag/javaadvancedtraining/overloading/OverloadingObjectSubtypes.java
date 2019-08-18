package org.kostiskag.javaadvancedtraining.overloading;

import java.util.HashSet;
import java.util.Set;

public class OverloadingObjectSubtypes {

//    void getNum(Integer n){
//        System.out.println("Greetings "+"getNum(Integer n)");
//    }

    void getNum(Number n){
        System.out.println("Greetings "+"getNum(Number n)");
    }

//    void giveSet(HashSet s) {
//        System.out.println("Greetings "+"giveSet(HashSet s)");
//    }

    void giveSet(Set s) {
        System.out.println("Greetings "+"giveSet(Set s)");
    }

    public static void main(String[] args) {
        OverloadingObjectSubtypes o = new OverloadingObjectSubtypes();

        //if overloading cannot find the object's type, it will look for a supertype argument!
        o.getNum(new Integer(5));

        HashSet s = new HashSet();
        o.giveSet(s);


    }


}
