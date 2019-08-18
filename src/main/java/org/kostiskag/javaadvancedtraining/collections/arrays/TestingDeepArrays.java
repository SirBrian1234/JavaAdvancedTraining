package org.kostiskag.javaadvancedtraining.collections.arrays;

import java.util.Arrays;

public class TestingDeepArrays {

    public static void main(String[] args) {
        int[] inner = {3,4,5,6};

        int[][] outer = {inner,inner, inner, inner};

        System.out.println(Arrays.deepToString(outer));
        System.out.println(Arrays.deepHashCode(outer));
        System.out.println(Arrays.deepEquals(outer, outer));
    }
}
