package org.kostiskag.javaadvancedtraining.collections;

import java.util.*;
import java.util.stream.Collectors;

public class TestingMaps2 {

    public static void main(String[] args) {
        /*
            Hash map
         */
        Map<Integer, Boolean> h = new TreeMap<>((a,b)-> -a.compareTo(b));
        h.put(3,true);
        h.put(4,false);
        h.put(2,true);
        h.put(15,true);
        h.put(2,false);
        h.put(5,false);

        System.out.println("this is our tree set! " + h);

        //Values
        // gives you back a Collection therefore in our case Collection Boolean it is not a set!!!
        // it may contain duplicate elements as values are independend from one another!
        //non-unique this is why the Collection
        //as were found on the map
        System.out.println(h.values());

        //KeySet
        //gives back a set of keys
        //sorted as in map
        //unique there goes the Set!
        System.out.println(h.keySet());

        //EntrySet
        //unique!
        System.out.println("entry set " + h.entrySet());


        //let's see now can a reference value point to the changes?
        Collection<Boolean> v = h.values();
        System.out.println("before " + v);
        h.put(22,true);
        System.out.println("after" + v);
        //YES it Can!

        var entries = h.entrySet();
        System.out.println(entries.stream().map(e -> e.getKey()).collect(Collectors.toList()));


        var m = Map.of(1, true, 2,false);
        //m.put(5,false); //runtime unsupported immutable
    }
}
