package assertionTest;

public class TestingClass {

    private static class pakis {
        @Override
        public String toString() {
            return "pakis to str";
        }
    }

    public static void main(String[] args) {
        assert args.length == 0;
        System.out.println(args.length);
        //assert args.length == 1: "ohhh...";
        assert args.length == 1 : new pakis(); //so it derives to string
    }
}
