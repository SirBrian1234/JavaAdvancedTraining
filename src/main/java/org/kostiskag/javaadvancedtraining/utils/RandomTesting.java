package org.kostiskag.javaadvancedtraining.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class RandomTesting {
    public static void main(String[] args) {

        //Random is a generator of numbers!!!!
        Random r = new Random();
        Random r2 = new Random(new Date().getTime());


        System.out.println(r); //no toString override!
        System.out.println(r2);

        ///r.ints().forEach(System.out::println); //infinite stream...

        var arr = r.ints().limit(10).toArray();
        System.out.println(Arrays.toString(arr));

        for (int i=0; i<50; i++) {
            System.out.println(r.nextBoolean());
        }
        for (int i=0; i<50; i++) {
            System.out.println(r.nextGaussian());
        }
        for (int i=0; i<50; i++) {
            Double d = r.nextGaussian();
            //System.out.println(d);
            int j = (int) Math.ceil(d*10);
            if (j>0){
                System.out.print("          ");
            }
            for(int k = Math.abs(j); k>0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }

        try {
            SecureRandom sec = SecureRandom.getInstance("SHA1PRNG");
            //sec.reseed();
            for (int i=0; i<50; i++) {
                System.out.println("secure " + sec.nextDouble());
            }


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
