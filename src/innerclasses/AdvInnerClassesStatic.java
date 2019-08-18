package innerclasses;

public class AdvInnerClassesStatic {

    static class InnerClass {
        int x;

        public InnerClass(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }
    }

    void print() {
        InnerClass in = new InnerClass(5);
        System.out.println(in.getX());
    }


    public static void main(String[] args) {
        //since Inner is default it may be used from all the package
        AdvInnerClassesStatic.InnerClass i = new InnerClass(6);
    }
}
