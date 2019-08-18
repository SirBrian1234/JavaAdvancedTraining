package org.kostiskag.javaadvancedtraining.sync;

import java.util.concurrent.Phaser;

public class PhaserTest {

    Phaser ph = new Phaser(1);
    StringBuffer buf = new StringBuffer("John had an uncle whose father was ");

    private static class AddRelative extends Thread {
        Phaser ph;
        StringBuffer b;
        String msg;

        AddRelative(Phaser ph, StringBuffer b, String msg) {
            this.msg = msg;
            this.b = b;
            this.ph = ph;
            ph.register();
        }

        @Override
        public void run() {
            while (true) {
                b.append(msg);
                System.out.println(Thread.currentThread().getName()+"waits...");
                ph.arriveAndAwaitAdvance();
            }
        }
    }

    public static void main(String[] args) {
        PhaserTest phT = new PhaserTest();
        //phT.ph.register();

        new AddRelative(phT.ph, phT.buf,"Bob whose uncle was ").start();
        new AddRelative(phT.ph, phT.buf,"Bill whose grandfather was ").start();
        new AddRelative(phT.ph, phT.buf,"David whose son was ").start();

        phT.ph.arriveAndAwaitAdvance();
        System.out.println("phase... "+ phT.ph.getPhase());
        System.out.println(phT.buf);

        phT.ph.arriveAndAwaitAdvance();
        System.out.println("phase... "+ phT.ph.getPhase());
        System.out.println(phT.buf);

        phT.ph.arriveAndAwaitAdvance();
        System.out.println("phase... "+ phT.ph.getPhase());
        phT.buf.append("Martha!");
        System.out.println(phT.buf);

    }
}
