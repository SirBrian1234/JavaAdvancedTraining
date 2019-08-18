package inheritance;

/**
 * Compile time errors are raised when classes do not match their requirements
 * The compiler finds in one swipe all the errors and points in each method's name!
 */
public class WhereWillItBreakInterfaceAbstract {

    interface ObeyMe {
        void soCallMeMaybe();
    }

    static abstract class ObeyMeClass {
        abstract void callMe();
    }

//    static class BB implements ObeyMe { //compiler cleanly breaks on the first line of the class if soCallMeMaybe is not implemented!
////        public void soCallMeMaybe() {
////            System.out.println("But here's my number, so call me maybe from class " + BB.class.getSimpleName());
////        }
//    }
//    //java: inheritance.WhereWillItBreakInterfaceAbstract.BB is not abstract and does not override abstract method soCallMeMaybe()
//
//    static class BBB extends ObeyMeClass { //compiler cleanly breaks on the first line of the class if callMe is not implemented!
////        public void callMe() {
////            System.out.println("But here's my number, so call me from class " + BBB.class.getSimpleName());
////        }
//    }
//    //java: inheritance.WhereWillItBreakInterfaceAbstract.BBB is not abstract and does not override abstract method callMe()

    public static void main(String[] args) {

//        BB a = new BB();
//        BBB b = new BBB();
    }
}
