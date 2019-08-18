package org.kostiskag.javaadvancedtraining.overloading;

/**
 * In general when there is not the primitive overload type we are seeking
 * it moves all the way up the primitive data types,
 *
 * if an overload signature is still not to be found,
 * it looks for autoboxing!
 */
public class OverloadingPrimitives {

    //overloading is based on type promotion when a method is not found!!!

    public void hello(byte i) {
        System.out.printf("Hello from : void hello(byte i)");
    }

//    public void hello(short i) {
//        System.out.printf("Hello from : void hello(short i)");
//    }
//
//    public void hello(int i) {
//        System.out.printf("Hello from : void hello(int i)");
//    }

//    public void hello(long i) {
//        System.out.printf("Hello from : void hello(long i)");
//    }

//   public void hello(float i) {
//        System.out.printf("Hello from : void hello(float i)");
//    }

    public void hello(double i) {
        System.out.printf("Hello from : void hello(double i)");
    }

//    public void hello(char i) {
//        System.out.printf("Hello from : void hello(char i)");
//    }

    public void hello(Integer i) {
        System.out.printf("Hello from : void hello(Integer i)");
    }

    public void hello(Long i) {
        System.out.printf("Hello from : void hello(Long i)");
    }

    public void hello(Float i) {
        System.out.printf("Hello from : void hello(Float i)");
    }

    public void hello(Double i) {
        System.out.printf("Hello from : void hello(Double i)");
    }

    public static void main(String[] args) {
        OverloadingPrimitives o = new OverloadingPrimitives();
        //o.hello(false); // java: no suitable method found for hello(boolean)
        o.hello((byte)0xff);
        //o.hello(0.5f);  // float can not resolve to int, resolves to double
        //o.hello('c');   // char resolves to int
        o.hello(5L);
        //o.hello(5);

        //byte ->  short -> int -> long -> float -> double
        //char -> int -> long -> float -> double
        //boolean -> x

        //type promotion will not work with non-primitive numeric types like Integer Double
        //only autoboxing will work meaning that if
        //hello(5); is called and there is no hello(Integer) it will not resolve to hello(Long) or hello(Double)
    }

}
