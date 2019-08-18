package overloading;

/**
 *
 */
public class OverloadingPrimitivesTwoArgsAmbiguous {

    public void hello(float i, double j) {
        System.out.printf("Hello from : void hello(float i, double j)");
    }

    public void hello(double i, float j) {
        System.out.printf("Hello from : void hello(double i, float j)");
    }

    public static void main(String[] args) {
        OverloadingPrimitivesTwoArgsAmbiguous o = new OverloadingPrimitivesTwoArgsAmbiguous();

        //all below fail
        // java: reference to hello is ambiguous
        //  points always to the caller!
//      o.hello(4,5);
//      o.hello(5L,4L);
//      o.hello(4.0f, 5.0f);


        //we have described the minimum required typecast!
        //o.hello((double) 4,5);
    }

}
