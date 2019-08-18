package org.kostiskag.javaadvancedtraining.collections.arrays;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysTesting {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //binary search
        System.out.println(Arrays.binarySearch(array, 5)); //4
        System.out.println(Arrays.binarySearch(array, 9)); //8
        System.out.println(Arrays.binarySearch(array, 15)); //-10
        System.out.println(Arrays.binarySearch(array,  0, 3, 5)); //-4

        //RUNTIME EXC
        //System.out.println(Arrays.binarySearch(array,  3, 0, 5)); //illegal argument exception raised runtime
        //System.out.println(Arrays.binarySearch(array,  -2, 3, 5)); //array index out of bounds runtime

        //REMEMBER the key argument goes always after the range! this is test dangerous!
        System.out.println(Arrays.binarySearch(array,  0, 4, 5));
        //the value 5 is on index 4 however the range does not include the end as an element

        //copy of
        //copy of range
        int[] array2 = Arrays.copyOfRange(array, 2,7);
        System.out.println("range copy " + Arrays.toString(array2));

        int[] array3 = Arrays.copyOf(array2, 3);
        System.out.println("copy of " + Arrays.toString(array3));

        //fill
        //fill subsert
        int[] array4 = new int[11];
        Arrays.fill(array4, 0 , 10, 15); //fill needs to work on an instantiated array
        //it is not smart, you can not apply an algorithm, it will just place the same value everywhere
        //it does not return anything

        // equals
        System.out.println(Arrays.equals(array2, array3)); //false....
        System.out.println(Arrays.equals(array2, 0, 3, array3, 0, array3.length)); //true!!!!!!! when comparing the subset

        // sort
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        // parallel sort
        Arrays.parallelSort(array);
        System.out.println(Arrays.toString(array));
        // sort subset
        Arrays.sort(array, 0, 5);

        // DANGER!!!!!!
        System.out.println("set all before " + Arrays.toString(array));

        Arrays.setAll(array, (x) -> x + 2);
        System.out.println("set all " + Arrays.toString(array));

        //THIS IS THE SAME!!!!!
        //stream with range!!!! and collect
        Arrays.stream(array, 2,5).boxed().collect(Collectors.toList());
        //oooor!!!
        IntStream.of(array).boxed().collect(Collectors.toList());

        // the problem when streaming an array is that you don't have a way to access an index
        // which in many cases is needed as it defines an incremental way to identify the next element
        // of course there is no problem with lambdas, it's just how we use them!
        // Instead of starting from the MAP start from a RANGE and then use .map() to map the
        // incremental elements to the map elements
        int[] array5 = IntStream.range(0,30).map(x -> x * 2).toArray();
        System.out.println("array 5 " + Arrays.toString(array5));

        //as compared to fill setAll is able to have some intelligence as it may use a lambda
        Arrays.setAll(array5, (x) -> x * 2); //WARNING x is the INDEX of this POSITION!!!
        //You specify what will happen to the element BASED on the index!
        System.out.println("array 5 " + Arrays.toString(array5));

        //THEREFORE
        array5 = IntStream.range(0,30).map(x -> x * 2).toArray();
        //and
        Arrays.setAll(array5, (x) -> x * 2); //x is the index!
        //ARE EQUAL!!!!!!!! except the fact that setAll needs an instantiated array to operate on...
        //They both use an index to set the array!

        //THIS IS DIFFERENT!!!
        array5 = Arrays.stream(array5).map(x -> x * 2).toArray(); // make the element the double from what it is!!!!
        array5 = Arrays.stream(array5).map(x -> x * 2).toArray(); // x is the element!
        //Why??? because the operator does not apply on the index but in the element's existing value!!!
        System.out.println("array 5 " + Arrays.toString(array5));


        // different way of using set all using an anonymous inner class!
        Arrays.setAll(array5, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * 2;
            }
        });
        System.out.println("array 5 anonymous " + Arrays.toString(array5));

        Stream.of();
        List.of();
        Set.of();
        Arrays.asList();

    }
}
