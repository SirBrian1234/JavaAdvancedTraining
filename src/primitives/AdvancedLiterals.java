package primitives;

public class AdvancedLiterals {

    public static void main(String[] args) {

        short a = 0xfff; //hex
        short b = 042334; //octal
        short c = 0b011111111___1_111111; //binary

        int wapaf = 'c';

        //underscores apply to all numeric literals! hex octal binary decimal
        a = 5___5;
        a = 0xf_f__f;
        b = 04_23___34;
        c = 0b01111_1111_1111_111; //binary

        int x = 0xfffff;
        int y = 024515667;
        int z = 0b010101010111100;

        long xx = 0xfffffL;
        long yy = 024515667L;
        long zz = 0b010101010111100L;

        double aa = 4_2.4_4;
        //double aaa = 4_2_.4_4; //Error:(20, 25) java: illegal underscore
        //double aaa = 4_2._4_4;  //Error:(21, 26) java: illegal underscore

        //character literals
        char ch = 'a';
        ch = '\141';
        System.out.println(ch);
        ch = '\uffff';
        System.out.println(ch);
        ch = '\uffff'; // slash, u and four hex chars
        System.out.println(ch);
        ch = '\ua432'; // slash, u and four hex chars
        System.out.print(ch);
        ch = '\b'; //backspace
        System.out.println(ch);
    }
}
