package org.kostiskag.javaadvancedtraining.sync;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest extends Thread {

    private final CountDownLatch cl = new CountDownLatch(1);

    @Override
    public void run() {
        System.out.println("Waiting");
        try {
            cl.await();
        } catch (InterruptedException e) {
          return;
        }

        System.out.println("Ready to work!");
    }

    public void fire() {
        cl.countDown();
    }

    public static void main(String[] args) {
        var ctest = new CountDownLatchTest();
        ctest.start();

        try {
            sleep(5000);
        } catch (InterruptedException e ) {

        }

        ctest.fire();

    }

}
