package org.kostiskag.javaadvancedtraining.varargs;

public class VarargsAmbiguous {

//    void callThis(int x) {
//        System.out.println("success!");
//    }

    void callThis(int...vals) {
        System.out.println("successA!");
    }

    void callThis(int x, int...vals) {
        System.out.println("successB!");
    }


    public static void main(String[] args) {
        var a = new VarargsAmbiguous();

//        a.callThis(5); //java: reference to callThis is ambiguous
//        a.callThis(5, 6); //java: reference to callThis is ambiguous
//        a.callThis(5, 6, 7); //java: reference to callThis is ambiguous

        //you can only use it like this, so the whole varargs intention for comma separated elements
        //goes away!
        a.callThis(new int[]{1,2,3,4});
        a.callThis(5, new int[]{1,2,3,4});

        //WARNING!!! if you NEVER call a method the compiler will NEVER know that they are ambiguous
    }
}
