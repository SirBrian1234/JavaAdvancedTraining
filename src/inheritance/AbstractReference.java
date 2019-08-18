package inheritance;

public class AbstractReference {

    static abstract class AbsMe {
        void greeting() {
            System.out.println("Hello!!!!");
        }

        abstract int giveMeANum(int val);

        // You are allowed to have implementations of an
        // abstract class inside it!
        static class AbsThat extends  AbsMe {
            @Override
            int giveMeANum(int val) {
                return 0;
            }
        }

        static {
            //You can use static in an abstract!!!!
            System.out.println("wiiiiiiii!!!!");
        }
    }

    static class AbsSuper extends AbsMe {
        @Override
        int giveMeANum(int val) {
            return 0;
        }
    }

    public static void main(String[] args) {
        AbsMe a = new AbsSuper();
        a.greeting();
        a.giveMeANum(5);

        AbsMe b = new AbsMe() {
            @Override
            int giveMeANum(int val) {
                return 0;
            }
        };
    }
}
