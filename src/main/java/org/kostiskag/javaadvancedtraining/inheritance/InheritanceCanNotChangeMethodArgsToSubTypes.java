package org.kostiskag.javaadvancedtraining.inheritance;

import java.util.HashSet;
import java.util.Set;

public class InheritanceCanNotChangeMethodArgsToSubTypes {

    interface A {
        void soCallMeMaybe(Set set);
    }

    abstract class AA {
        abstract void soCallMeMaybe(Set set);
    }

//    static class B implements A { //java: B is not abstract and does not override abstract method ...
//        void soCallMeMaybe(HashSet set) {
//            System.out.println("But here's my number, so call me maybe from class " + B.class.getSimpleName());
//        }
//    }

//    static class BB extends AA { //java: BB is not abstract and does not override abstract method...
//        void soCallMeMaybe(HashSet set) {
//            System.out.println("But here's my number, so call me maybe from class " + B.class.getSimpleName());
//        }
//    }

    public static void main(String[] args) {
//        B b = new B();
//        BB bb = new BB();
    }
}
