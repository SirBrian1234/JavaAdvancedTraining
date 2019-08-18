package org.kostiskag.javaadvancedtraining.interfaces;

public interface PermittedActionsInteraface {

    //int x; //vars have to be instantiated
    //implicit static finals
    int x = 5;
    int y = 7;

    enum hello {
        HI, THERE;
    }

    class Wiii{
        public Wiii() {

        }
    }

    interface Wapaf {

    }

    //static block is not allowed
    /*
    static {

    }
    */

    static void greeting() {
        System.out.println("Hi");
    }

    //usual case
    int addition(int x, int y);
    int substraction(int x, int y);

    //Default example
    default int division(int x, int y) {
       return y!=0? x/y: 0;
    }

//    //Default Final Is not ALLOWED example
//    default final int absolute(int x, int y) {
//        return 0;
//    }


    //Private example
    default void hello() {
        greet();
    }

    default void hi() {
        //x = 15; //x is effectively final
        greet();
    }

    private void greet() {
        System.out.println("Hiiii");
    }

    public static void helloMe() {
        System.out.println("Hello!");
    }

}
