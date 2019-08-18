package overloading;

/**
 *  Even though we have autoboxing there are some ambiguous overloading cases where we may have to use casting to differentiate between
 *  a primitive signature and an object signature!
 */
public class OverloadingAutoboxingAmbiguous {


//    void getMe(int n) {
//        System.out.println("Greetings "+"getMe int!");
//    }

    void getMe(double n) {
        System.out.println("Greetings "+"getMe double!");
    }

    void getMe(Integer n) { System.out.println("Greetings "+"from getMe Integer!"); }

    char getHer(int n) { System.out.println("You didn't get her!"); return 'a';}

    int getHer(Integer n) { System.out.println("You got her!"); return -1;}

    public static void main(String[] args) {

        OverloadingAutoboxingAmbiguous o = new OverloadingAutoboxingAmbiguous();

        o.getMe(5); //guess which of the above two methods will be called?
        //the int
        //it will pick the double and not autobox!

        o.getMe((Integer) 5); //to call getMe Integer in this case we have to use casting

        int r = o.getHer(5); //even though the return type is expected to be an int it still does not care
        //as it has to be reminded that the return type is not a part of the method's signature!

        int e = o.getHer((Integer) 5);
    }


}
