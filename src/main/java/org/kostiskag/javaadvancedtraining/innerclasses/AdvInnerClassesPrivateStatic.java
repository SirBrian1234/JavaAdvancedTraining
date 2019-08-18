package org.kostiskag.javaadvancedtraining.innerclasses;

/**
 * First you need to create an object of AdvInnerClassesPrivateStatic
 * then with that object to create an object of InnerClass inside it
 */
public class AdvInnerClassesPrivateStatic {

    private static class InnerClass {
        int x;

        public InnerClass(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }
    }

    void print() {
        InnerClass in = new InnerClass(5);
        System.out.println(in.getX());
    }


    public static void main(String[] args) {
        //you can use a private from the inside
        AdvInnerClassesPrivateStatic.InnerClass i = new InnerClass(6);
        System.out.println(i.getX());
    }
}

