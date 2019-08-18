package org.kostiskag.javaadvancedtraining.varargs;

/**
 * This is the intended way of using varargs!
 */
public class VarargsProper {

    void callThis(int x) {
        System.out.println("successA!");
    }

    void callThis(int x, int y) {
        System.out.println("successB!");
    }

    void callThis(int x, int y, int z) {
        System.out.println("successC!");
    }

    void callThis(int...vals) {
        System.out.println("success Varargs!");
    }


    public static void main(String[] args) {
        var a = new VarargsProper();

        //All the following are overloaded versions
        a.callThis(5);
        a.callThis(5, 6);
        a.callThis(5, 6, 7);
        a.callThis(5, 6, 7, 8);

    }
}
