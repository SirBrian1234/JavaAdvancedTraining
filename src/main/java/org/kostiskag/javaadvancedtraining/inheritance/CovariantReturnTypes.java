package org.kostiskag.javaadvancedtraining.inheritance;

import java.util.HashSet;
import java.util.Set;

/**
 * You can easily override and replace the return type with a subtype!
 * Although you can not do the same for the methods arguments
 * which always stay the same!
 *
 * DANGER!!! if an Object object is returned it may be subclassed into any ohter object!!!!!!!
 */
public class CovariantReturnTypes {

    static class A {
        Number soCallMeMaybe() {
            System.out.println("Number");
            return 5;
        }

        Set soCallMeMaybe(int x) {
            System.out.println("Set");
            return new HashSet();
        }

        //Never use an object as a return type as
        //Covariant return types may exploit it
        //Use generics instead as they properly indicate your intentions
        //And may be better bounded
        Object soCallMeMaybe(float x) {
            return new Object();
        }

        int soCallMeMaybe(double x) {
            System.out.println("int");
            return 0;
        }

    }

    static class B extends A {
        Integer soCallMeMaybe() {
            System.out.println("Integer");
            return 6;
        }

          // You may fully exploit object to return any object return type you want!
//        @Override
//        String soCallMeMaybe(float x) {
//            return "hey!";
//        }

        @Override
        Integer soCallMeMaybe(float x) {
            return 5;
        }


//        char soCallMeMaybe(double x) { //java: soCallMeMaybe(double) cannot override soCallMeMaybe(double) return type char is not compatible with int
//            System.out.println("HashSet");
//            //return new HashSet();
//        }
    }

    public static void main(String[] args) {
        //No arguing this time from the compiler
        //the return type is not a part of the methods signature
        B b = new B();

        System.out.println("You will get an: " + b.soCallMeMaybe());
        System.out.println("You will get an: " + b.soCallMeMaybe(5));
        System.out.println("You will get an: " + b.soCallMeMaybe(5f));
    }
}
