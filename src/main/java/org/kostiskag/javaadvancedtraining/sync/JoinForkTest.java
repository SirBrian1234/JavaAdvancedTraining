package org.kostiskag.javaadvancedtraining.sync;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class JoinForkTest {

    private static class IncrementArray extends RecursiveAction {
        int[] array;
        int start;
        int end;

        public IncrementArray(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if ((end - start) < 20) {
                for(int i=start; i < end; i++) {
                    array[i]++;
                }
            } else {
                int middle = (start + end)/2;
                var a = new IncrementArray(array, start,middle);
                var b = new IncrementArray(array, middle, end);
                invokeAll(a, b);
            }
        }
    }

    private static class SumUpArray extends RecursiveTask<Integer> {
        int[] array;
        int start;
        int end;

        public SumUpArray(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum =0;
            if (end - start < 20) {
                for(int i = start; i < end; i++) {
                    sum += array[i];
                }
            } else {
                int middle = (start + end)/2;

                var a = new SumUpArray(array, start, middle);
                var b = new SumUpArray(array, middle, end);
                a.fork();
                b.fork();

                sum = a.join() + b.join();
            }

            return sum;
        }
    }

    public static void main(String[] args) {

        ForkJoinPool fjp = new ForkJoinPool();

        int[] arrayToInc = new int[10000];
        var i = new IncrementArray(arrayToInc, 0, arrayToInc.length);

        //This is a RecursiveAction
        System.out.println(System.currentTimeMillis()+" started" + Arrays.toString(arrayToInc));
        fjp.invoke(i);
        System.out.println(System.currentTimeMillis()+" stopped" + Arrays.toString(arrayToInc));

        //This is a RecursiveTask
        var j = new SumUpArray(arrayToInc, 0, arrayToInc.length);
        int sum = fjp.invoke(j);
        System.out.println("sum is "+sum);
    }

}
