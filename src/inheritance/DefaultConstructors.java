package inheritance;

public class DefaultConstructors {

    static class A {
        public int val;

        //hey i am a default constructor but i am very naughty
        //I wil be called even if i am private
        private A() {
            val = 5;
        }

        public A(int val) {
            this.val = val;
        }
    }

    static class B extends A {
        public int valB;

        public B() {
            valB = 15;
        }

        public B(int valB) {
            this.valB = valB;
            //we didn't call super so there is no way to change the default constructor from A
        }
    }

    static class C extends B {

        public C() {

        }

        public C(int a) {
            super(a);
        }
    }

    public static void main(String[] args) {
        C c = new C();

        System.out.println("val " + c.val);
        System.out.println("valB " + c.valB);


        c = new C(7);

        System.out.println("val " + c.val);
        System.out.println("valB " + c.valB);
    }
}
