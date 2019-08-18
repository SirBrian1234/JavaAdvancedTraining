package org.kostiskag.javaadvancedtraining.primitives;

public class AdvancedArrays {
    public static void main(String[] args) {
        //primitive
        int x  = 5;
        int[] bamies = {x, x, x, x};
        x = 6;

        for (int i=0 ; i< bamies.length; i++) {
            System.out.println(bamies[i]);
        }

        //immutable object
        Integer y  = 5;
        Integer[] bamies2 = {y, y, y};
        y = 6;

        for (int i=0 ; i< bamies2.length; i++) {
            System.out.println(bamies2[i]);
        }

        //mutable object
        class MutableInt{
            int value;

            public MutableInt(int value) {
                this.value = value;
            }
        }

        // This is the reason why Integers are immutable objs
        // to prevent disasters like the following!!!
        MutableInt elem  = new MutableInt(5);
        MutableInt[] bamies3 = {elem, elem, elem, elem, elem, elem};
        elem.value = 10;

        for (int i=0 ; i< bamies3.length; i++) {
            System.out.println(bamies3[i].value); //we are going to see that all elements have become 10
        }

        //arrays with local type inference!
        var array = new int[10];
        //var[] arrayd = new int[10]; //java: 'var' is not allowed as an element type of an array
        //var arrays[] = new int[10];   //java: 'var' is not allowed as an element type of an array

        var var = new int[5][];
        var[0] = new int[4];



        //var var = 5;

//        class var{
//
//        }
        //you cant use var for a class name

       // final var bamies444 = 15;
    }
//
//    public int lookWhatICanDo(final int height, final int width) {
//        //height = 5; //i just cant it's final!!!!
//        return height * width;
//    }
}
