package org.kostiskag.javaadvancedtraining.sync;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    Semaphore s = new Semaphore(1, true);

    private class UserA extends Thread {

        private final Semaphore s;
        private final String message;

        public UserA(Semaphore sem, String message) {
            this.s = sem;
            this.message = message;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    s.acquire();
                    System.out.println("Hello from Thread:"+Thread.currentThread().getName()+" "+message);
                } catch (InterruptedException e) {
                    System.err.println("interrupted "+e.getLocalizedMessage());
                } finally {
                    s.release();
                }
            }
        }
    }

    public SemaphoreTest() {
        this.s = new Semaphore(1);
    }

    public Semaphore getS() {
        return s;
    }

    public static void main(String[] args) {
        SemaphoreTest s  = new SemaphoreTest();
        var a = s.new UserA(s.getS(), "Hello!");
        var b = s.new UserA(s.getS(), "Hi there!");
        var c = s.new UserA(s.getS(), "Heeey!");
        a.start();
        b.start();
        c.start();
    }
}
