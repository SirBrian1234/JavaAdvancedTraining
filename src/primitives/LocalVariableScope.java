package primitives;

public class LocalVariableScope {

    static int num = 4;

    public static void main(String[] args) {
        System.out.println(num);
        int x = 5;
        {
           //int x = 7; //java: variable x is already defined in method main(java.lang.String[])
            x = 7;
            //yes you can open and close brackets whenever you need to!!!!
            {
                int j = 15;
                System.out.println(j);
            }
            //System.out.println(j);  //Error:(13, 32) java: cannot find symbol  symbol:   variable j
        }
        System.out.println(x);
    }

    //the static block will be executed after the static variable assignments
    static {
        LocalVariableScope.num = 14;
    }
}
