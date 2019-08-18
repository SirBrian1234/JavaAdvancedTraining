package primitives.operators;

public class BitsAndShifts {
    public static void main(String[] args) {
        byte b = (byte) 0xff;
        byte a = (byte) 0xaa;
        byte c = (byte) 0b0001;

        c <<= 1;
        System.out.println(c);

        c <<= 1;
        System.out.println(c);

        c <<= 1;
        System.out.println(c);
    }
}
