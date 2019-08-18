package org.kostiskag.javaadvancedtraining.inheritance;

public class TripleInheritance {

    static class A {
        void soCallMeMaybe() {
            System.out.println("But here's my number, so call me maybe from class " + A.class.getSimpleName());
        }
    }

    static class B extends A {
        void soCallMeMaybe() {
            System.out.println("But here's my number, so call me maybe from class " + B.class.getSimpleName());
        }
    }

    static class C extends B {
        void soCallMeMaybe() {
            System.out.println("But here's my number, so call me maybe from class " + C.class.getSimpleName());
        }
    }

    public static void main(String[] args) {
        //reference variables
        A a = new A();
        A b = new B();
        A c = new C();

        //what will be printed on screen????
        a.soCallMeMaybe();
        b.soCallMeMaybe();
        c.soCallMeMaybe();
    }
}
