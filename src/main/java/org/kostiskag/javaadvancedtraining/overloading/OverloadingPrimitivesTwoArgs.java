package org.kostiskag.javaadvancedtraining.overloading;

/**
 * It tries to find the closest possible fit based on type promotion
 * It will select the next closest matching type if there are many compatible types
 *
 * In primitive if an argument is not found overloading looks for the next available primitive
 * it always looks for the closer overloaded method!!!
 */
public class OverloadingPrimitivesTwoArgs {

    public void hello(long i, double j) {
        System.out.printf("Hello from : void hello(long i, double j)");
    }

    public void hello(long i, float j) {
    System.out.printf("Hello from : void hello(long i, float j)");
}

    public void hello(float i, float j) {
        System.out.printf("Hello from : void hello(float i, float j)");
    }

    public static void main(String[] args) {
        OverloadingPrimitivesTwoArgs o = new OverloadingPrimitivesTwoArgs();
        o.hello(5L,4L); //Hello from : void hello(long i, float j)
        //it didn't pick hello(long i, double j)
        // because it was 2 levels ahead whereas hello(long i, float j) was only one for j type
    }

}
