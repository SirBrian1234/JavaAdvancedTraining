package org.kostiskag.javaadvancedtraining.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService s = Executors.newFixedThreadPool(2);

        s.execute(() -> {
            for(int i=0; i< 100; i++) {
                System.out.println("Bolek");
            }
        });

        s.execute(() -> {
            for(int i=0; i< 100; i++) {
                System.out.println("Lolek");
            }
        });

        s.shutdown();
    }
}
