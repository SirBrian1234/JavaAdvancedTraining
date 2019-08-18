package org.kostiskag.javaadvancedtraining.sync;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SemaphoreWithCountDownLatchExample extends Thread {

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

    final CountDownLatch cb = new CountDownLatch(numOfThreads);
    final Semaphore sForStack = new Semaphore(1);

    final Deque<int[]> chunks = new ArrayDeque<int[]>();
    final Deque<int[]> sortedchunks = new ArrayDeque<int[]>();

    public SemaphoreWithCountDownLatchExample() {
        chunks.push(IntStream.range(0,20).map(i -> shuffledArr[i]).toArray());
        chunks.push(IntStream.range(20,40).map(i -> shuffledArr[i]).toArray());
        chunks.push(IntStream.range(40,60).map(i -> shuffledArr[i]).toArray());
        chunks.push(IntStream.range(60,80).map(i -> shuffledArr[i]).toArray());
        chunks.push(IntStream.range(80,100).map(i -> shuffledArr[i]).toArray());
        System.out.println("len of chunks "+chunks.size());
    }

    @Override
    public void run() {
       try {
           cb.await();
       } catch (InterruptedException e) {

       }

       System.out.println("ready to begin!");
       System.arraycopy(sortedchunks.pop(),0,result,0,20);
       System.arraycopy(sortedchunks.pop(),0,result,20,20);
       System.arraycopy(sortedchunks.pop(),0,result,40,20);
       System.arraycopy(sortedchunks.pop(),0,result,60,20);
       System.arraycopy(sortedchunks.pop(),0,result,80,20);

       System.out.println(Arrays.toString(result));
       Arrays.sort(result);
       System.out.println(Arrays.toString(result));

    }

    public class ChunkSorter extends Thread{
        int[] toSort;

        ChunkSorter() {
            toSort = chunks.pop();
        }

        @Override
        public void run() {
            Arrays.sort(toSort);
            try {
                sForStack.acquire();
                sortedchunks.push(toSort);
            } catch (InterruptedException e) {

            } finally {
                sForStack.release();
            }

            System.out.println("done "+sortedchunks.size());
            cb.countDown();
        }
    }

    public static void main(String[] args) {
        SemaphoreWithCountDownLatchExample b = new SemaphoreWithCountDownLatchExample();
        b.start();

        b.new ChunkSorter().start();
        b.new ChunkSorter().start();
        b.new ChunkSorter().start();
        b.new ChunkSorter().start();
        b.new ChunkSorter().start();
    }
}
