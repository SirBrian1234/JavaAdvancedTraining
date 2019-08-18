package org.kostiskag.javaadvancedtraining.sync;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

/**
 * You have n tasks doing something
 * until all of them have to wait each other in order to continue
 *
 * ------------                |
 * -----------------------     |
 * ----------------            |
 * --------------------------- |
 *                             |---------------------------
 *
 * from this point and on another thread is executed!
 */
public class CyclicBarrierTest {

    public final static int[] shuffledArr;
    public final static int numOfThreads;
    static int[] result;

    static {
        var li = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        Collections.shuffle(li);
        shuffledArr = li.stream().mapToInt(i -> (int)i).toArray();
        numOfThreads = 100/20;
        result = new int[100];
    }

    final Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("ready to begin!");
            System.arraycopy(sortedchunks.pop(),0,result,0,20);
            System.arraycopy(sortedchunks.pop(),0,result,20,20);
            System.arraycopy(sortedchunks.pop(),0,result,40,20);
            System.arraycopy(sortedchunks.pop(),0,result,60,20);
            System.arraycopy(sortedchunks.pop(),0,result,80,20);

            System.out.println(Arrays.toString(result));
            Arrays.sort(result);
            System.out.println(Arrays.toString(result));

            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    final CyclicBarrier cb = new CyclicBarrier(5,r);


    final Semaphore sForStack = new Semaphore(1);

    final Deque<int[]> chunks = new ArrayDeque<int[]>();
    final Deque<int[]> sortedchunks = new ArrayDeque<int[]>();

    public CyclicBarrierTest() {
        chunks.push(IntStream.range(0,20).map(i -> shuffledArr[i]).toArray());
        chunks.push(IntStream.range(20,40).map(i -> shuffledArr[i]).toArray());
        chunks.push(IntStream.range(40,60).map(i -> shuffledArr[i]).toArray());
        chunks.push(IntStream.range(60,80).map(i -> shuffledArr[i]).toArray());
        chunks.push(IntStream.range(80,100).map(i -> shuffledArr[i]).toArray());
        System.out.println("###len of chunks "+chunks.size());
    }

    public class ChunkSorter extends Thread{
        int[] toSort;

        ChunkSorter() {
            toSort = chunks.pop();
        }

        @Override
        public void run() {
                System.out.println("Start! "+Arrays.toString(toSort));
                Arrays.sort(toSort);
                try {
                    sForStack.acquire();
                    sortedchunks.push(toSort);
                    System.out.println("done@@@ " + sortedchunks.size());
                } catch (InterruptedException e) {

                } finally {
                    sForStack.release();
                }

            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("it waits the all time the runnable takes place!!!!");
            System.out.println("hey i am here!");
        }
    }

    public static void main(String[] args) {
        CyclicBarrierTest b = new CyclicBarrierTest();

        System.out.println("Starting!!!");

        b.new ChunkSorter().start();
        b.new ChunkSorter().start();
        b.new ChunkSorter().start();
        b.new ChunkSorter().start();
        b.new ChunkSorter().start();

        System.out.println("Finished???");
    }
}
