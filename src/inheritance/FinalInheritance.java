package inheritance;

public class FinalInheritance {

    static class A {
        final void soCallMeMaybe() {
            System.out.println("But here's my number, so call me maybe from class " + A.class.getSimpleName());
        }
    }

    static class B extends A {
//        Error:(12, 14) java: soCallMeMaybe() in inheritance.FinalInheritance.B cannot override soCallMeMaybe() in inheritance.FinalInheritance.A
//        overridden method is final
//        void soCallMeMaybe() {
//            System.out.println("But here's my number, so call me maybe from class " + B.class.getSimpleName());
//        }
    }


    public static void main(String[] args) {

    }
}
