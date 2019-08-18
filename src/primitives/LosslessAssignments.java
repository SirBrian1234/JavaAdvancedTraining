package primitives;

public class LosslessAssignments {

    public static void main(String[] args) {
        //Type promotion is in play!
        boolean bool = true;
        char ch = 'a';

        byte b = 7;
        short sh = 5;
        int i = 4;
        long ln = 4;

        float fl = 8.5f;
        double d = 9.89;

        //EXAMPLE
        ln = i; //no casting, because long is bigger than int, it can accomodate it
        //e = c; // java: incompatible types: possible lossy conversion from long to byte, byte is smaller than long!
        //you can always assign a smaller sized primitive integer to a bigger sized type without a typecast
        //NO TYPECAST REQUIRED
        i = (byte) ln; // possible lossy

        //A char can fit-in to all primitive numbers except byte and short and not in the boolean type
        ln = ch;
        i  = ch;
        fl = ch;
        d = ch;
        //b = ch; // incompatible types: possible lossy conversion from char to short
        //sh = ch; // incompatible types: possible lossy conversion from char to byte


        //Everything can be assigned to a double! (except boolean)
        d = ln;
        d = i;
        d = sh;
        d = b;
        d = ch;
        d = fl;

        //Everything can be assigned to a float except double! (except boolean)
        fl = ln;
        fl = i;
        fl = sh;
        fl = b;
        fl = ch;

        //Everything can be assigned to a long except float, double! (except boolean)
        ln = i;
        ln = sh;
        ln = b;
        ln = ch;

        //Everything can be assigned to an int except long, float and double! (except boolean)
        i = sh;
        i = b;
        i = ch;

        //Everything can be assigned to a short except char, int, long, float and double! (except boolean)
        sh = b;

        //The end!!!!

        //the proper way to assign is to check boundaries first!
        if(ch >= Short.MIN_VALUE && ch <= Short.MAX_VALUE) {
            sh = (short) ch;
        }
    }
}
