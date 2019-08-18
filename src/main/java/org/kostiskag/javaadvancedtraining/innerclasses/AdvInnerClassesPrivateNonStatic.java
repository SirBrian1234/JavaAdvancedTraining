package org.kostiskag.javaadvancedtraining.innerclasses;

public class AdvInnerClassesPrivateNonStatic {

    private class InnerClass {
        int x;

        public InnerClass(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }
    }

    void print() {
        //yoy can still create instances of the class as without static
        InnerClass in = new InnerClass(5);
        System.out.println(in.getX());
    }

    public static void main(String[] args) {
        //You cant create an object in any static methods inside the class
        //AdvInnerClassesNonStatic.InnerClass i = new InnerClass(6);  //Error:(24, 49) java: non-static variable this cannot be referenced from a static context

        //Non-static is treated like an outer class field
        //SINCE WE ARE IN THE CLASS WE MAY INSTANTIATE!!!!
        AdvInnerClassesPrivateNonStatic o = new AdvInnerClassesPrivateNonStatic();
        AdvInnerClassesPrivateNonStatic.InnerClass in = o.new InnerClass(5);
        //not forget!!! o.new !!!!!!
    }
}
