package overloading;

/**
 *
 */
public class OverloadingPrimitivesOneArgAmbiguous {

    public void hello(Integer i) {
        System.out.printf("Hello from : void hello(Integer)");
    }

    public void hello(double i) {
        System.out.printf("Hello from : void hello(double)");
    }

    public static void main(String[] args) {
        OverloadingPrimitivesOneArgAmbiguous o = new OverloadingPrimitivesOneArgAmbiguous();

        o.hello(4);
        //it calls hello double instead of hello Integer!!!!
        //autoboxing works AFTER type promotion FAILS
    }

}
