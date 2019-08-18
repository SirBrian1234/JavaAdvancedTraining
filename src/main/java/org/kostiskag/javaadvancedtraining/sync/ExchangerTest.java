package org.kostiskag.javaadvancedtraining.sync;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

    public Exchanger<Integer> exchanger = new Exchanger();

    int counter = 0;

    private class IncreaseCount extends Thread {

        Exchanger<Integer> ex;

        public IncreaseCount(Exchanger<Integer> e) {
            this.ex =e;
        }

        @Override
        public void run() {
            int val = 0;
            while (true) {
                System.out.println(Thread.currentThread().getName() + " increasing count to: " + ++val);
                try {
                    val++;
                    val = exchanger.exchange(val);
                    System.out.println("did exchange " + val);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    };

    public static void main(String[] args) {
        ExchangerTest e = new ExchangerTest();

        e.new IncreaseCount(e.exchanger).start();
        e.new IncreaseCount(e.exchanger).start();
    }
}
