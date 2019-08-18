package org.kostiskag.javaadvancedtraining.collections.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysCompareTesting {
    public static void main(String[] args) {
        int[] array = new int[30];
        Arrays.fill(array, 0, 30, 1);
        System.out.println(Arrays.toString(array));

        for (int index = 0; index < array.length; index++) {
            array[index] = index;
        }
        System.out.println(Arrays.toString(array));

        int[] array2 = Arrays.copyOf(array, array.length);
        for (int index = array2.length/2; index < array2.length; index++) {
            array2[index]+=2;
        }
        System.out.println(Arrays.toString(array2));


        /*
            Compare
         */
        System.out.println(Arrays.compare(array, array2)); // -1 bc array2 is greater
        System.out.println(Arrays.compare(array, array));  // 0 bc array is equal to itself
        System.out.println(Arrays.compare(array2, array));  // 1 bc array2 is greater than array

        int[] array3 = Arrays.copyOf(array, array.length);
        for (int index = 0; index < array3.length; index++) {
            array3[index] = -array3[index];
            array3[index] += -4;
        }
        System.out.println(Arrays.toString(array3));


        /*
            CompareUnsigned
         */
        System.out.println(Arrays.compare(array3, array)); // -1 bc array is greater
        System.out.println(Arrays.compareUnsigned(array3, array)); // +1 bc array3's absolute values are greater than array's


        /*
            Mismatch
         */
        //remember we started changing array2 from array2.length/2
        //mismatch returns an index!
        System.out.println(Arrays.mismatch(array,array2)); //15 the middle index


        /*
            hashCode
         */
        System.out.println(Arrays.hashCode(array));

//        array = IntStream.range(0,30).toArray(); //creates a new array!
//        System.out.println(Arrays.toString(array));

    }
}
