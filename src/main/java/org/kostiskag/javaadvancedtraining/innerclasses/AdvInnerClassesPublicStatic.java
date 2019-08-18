package org.kostiskag.javaadvancedtraining.innerclasses;

public class AdvInnerClassesPublicStatic {

    public static class InnerClass {
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

    //Go to innerclasses.org.kostiskag.javaadvancedtraining.Main.main to use it!
}
