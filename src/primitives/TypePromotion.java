package primitives;

public class TypePromotion {
    public static void main(String[] args) {

        //type promotion
        char c = 'a';
        byte b = 42;
        short s = 15;
        int i = 400;
        long l = 21454;
        float f = 43.5f;

        //if you add a char and a short you will get an int!
        //s = s+c; //error: incompatible types: possible lossy conversion from int to short
        //if you multiply a short you will get an int
        //s = s*1; //error: incompatible types: possible lossy conversion from int to short
        i = s*2;
        i = c + s;


        //watch closely the return type
        float result = b + c + s + i +l + f;
        //as i suspected it long will promote to float even though long has a greater size capacity

        System.out.println(result);

        char  ch = 'w';
        int j = ch; // you can store a char to an int!
        long k = ch; // you can store a char to a long!
        float p = ch; // you can store a char to a float!
        double r = ch; // you can store a char to a double!


    }
}
